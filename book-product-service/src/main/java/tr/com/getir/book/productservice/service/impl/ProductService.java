package tr.com.getir.book.productservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.productdomain.entity.Product;
import tr.com.getir.book.productdomain.repository.ProductRepository;
import tr.com.getir.book.productdomain.repository.dao.IProductDao;
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
    private ProductConverter productConverter;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductDao productDao;

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = productConverter.toEntity(request.getProduct());
        productDao.insert(product);
        CreateProductResponse response = new CreateProductResponse();
        response.setProduct(productConverter.toDto(product));
        return response;
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        if (Util.isEmpty(request.getProduct().getId())) {
            throw new RequestException(ExceptionCode.PRODUCT_ID_NOT_FOUND);
        }
        Product originalProduct = productRepository.findById(request.getProduct().getId()).orElse(null);
        if (Util.isEmpty(originalProduct)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        Product product = productConverter.toEntity(request.getProduct());
        productDao.update(product);
        UpdateProductResponse response = new UpdateProductResponse();
        response.setProduct(productConverter.toDto(product));
        return response;
    }

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest request) {
        Product originalProduct = productRepository.findById(request.getProductId()).orElse(null);
        if (Util.isEmpty(originalProduct)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        productDao.delete(originalProduct);
        return new DeleteProductResponse();
    }

    @Override
    public GetProductResponse getProduct(GetProductRequest request) {
        Product product = productRepository.findById(request.getProductId()).orElse(null);
        if (Util.isEmpty(product)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productConverter.toDto(product));
        return response;
    }

    @Override
    public GetAllProductsResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (Util.isEmpty(products)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        GetAllProductsResponse response = new GetAllProductsResponse();
        response.setProducts(productConverter.toDtoList(products));
        return response;
    }
}
