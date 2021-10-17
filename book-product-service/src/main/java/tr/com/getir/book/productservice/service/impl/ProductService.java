package tr.com.getir.book.productservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.productdomain.entity.Product;
import tr.com.getir.book.productdomain.repository.ProductRepository;
import tr.com.getir.book.productservice.converter.ProductConverter;
import tr.com.getir.book.productservice.service.IProductService;
import tr.com.getir.book.productservice.view.request.CreateProductRequest;
import tr.com.getir.book.productservice.view.request.DeleteProductRequest;
import tr.com.getir.book.productservice.view.request.GetProductRequest;
import tr.com.getir.book.productservice.view.request.UpdateProductRequest;
import tr.com.getir.book.productservice.view.response.*;
import tr.com.getir.book.util.Util;

import java.util.List;

@Service
@Slf4j
public class ProductService implements IProductService {

    @Autowired
    private ProductConverter converter;

    @Autowired
    private ProductRepository repository;

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = converter.toEntity(request.getProduct());
        repository.save(product);
        CreateProductResponse response = new CreateProductResponse();
        response.setProduct(converter.toDto(product));
        return response;
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        if (Util.isEmpty(request.getProduct().getId())) {
            throw new RequestException(ExceptionCode.PRODUCT_ID_NOT_FOUND);
        }
        Product originalProduct = repository.findById(request.getProduct().getId()).orElse(null);
        if (Util.isEmpty(originalProduct)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        Product product = converter.toEntity(request.getProduct());
        repository.save(product);
        UpdateProductResponse response = new UpdateProductResponse();
        response.setProduct(converter.toDto(product));
        return response;
    }

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest request) {
        Product originalProduct = repository.findById(request.getProductId()).orElse(null);
        if (Util.isEmpty(originalProduct)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        repository.delete(originalProduct);
        return new DeleteProductResponse();
    }

    @Override
    public GetProductResponse getProduct(GetProductRequest request) {
        Product product = repository.findById(request.getProductId()).orElse(null);
        if (Util.isEmpty(product)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        GetProductResponse response = new GetProductResponse();
        response.setProduct(converter.toDto(product));
        return response;
    }

    @Override
    public GetAllProductsResponse getAllProducts() {
        List<Product> products = repository.findAll();
        if (Util.isEmpty(products)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        GetAllProductsResponse response = new GetAllProductsResponse();
        response.setProducts(converter.toDtoList(products));
        return response;
    }
}
