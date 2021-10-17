package tr.com.getir.book.productservice.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.productdomain.entity.Product;
import tr.com.getir.book.productdomain.repository.ProductRepository;
import tr.com.getir.book.productservice.validation.IProductValidation;
import tr.com.getir.book.productservice.view.model.ProductDto;
import tr.com.getir.book.util.Util;

public class ProductValidation implements IProductValidation {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product validateProduct(String productId) {
        if (Util.isEmpty(productId)) {
            throw new RequestException(ExceptionCode.PRODUCT_ID_NOT_FOUND);
        }
        Product product = repository.findById(productId).orElse(null);
        if (Util.isEmpty(product)) {
            throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        return product;
    }

    @Override
    public ProductDto validateProduct(ProductDto productDto) {
        if (Util.isEmpty(productDto)) {
            throw new RequestException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        return productDto;
    }

    @Override
    public Product validateProduct(Product product) {
        if (Util.isEmpty(product)) {
            throw new RequestException(ExceptionCode.PRODUCT_NOT_FOUND);
        }
        return product;
    }
}
