package tr.com.getir.book.productservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.productdomain.entity.Product;
import tr.com.getir.book.productdomain.repository.ProductRepository;
import tr.com.getir.book.productservice.converter.ProductConverter;
import tr.com.getir.book.productservice.service.IProductService;
import tr.com.getir.book.productservice.validation.impl.ProductValidation;
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

    @Autowired
    private ProductValidation validation;

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = converter.toEntity(request.getProduct());
        repository.save(product);
        return new CreateProductResponse(converter.toDto(product));
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        validation.validateProduct(request.getProduct().getId());
        Product product = converter.toEntity(request.getProduct());
        repository.save(product);
        return new UpdateProductResponse(converter.toDto(product));
    }

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest request) {
        Product product = validation.validateProduct(request.getProductId());
        repository.delete(product);
        return new DeleteProductResponse();
    }

    @Override
    public GetProductResponse getProduct(GetProductRequest request) {
        Product product = validation.validateProduct(request.getProductId());
        return new GetProductResponse(converter.toDto(product));
    }

    @Override
    public GetAllProductsResponse getAllProducts() {
        List<Product> products = repository.findAll();
        if (Util.isEmpty(products)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        return new GetAllProductsResponse(converter.toDtoList(products));
    }
}
