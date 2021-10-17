package tr.com.getir.book.productservice.validation;

import org.springframework.stereotype.Service;
import tr.com.getir.book.productdomain.entity.Product;
import tr.com.getir.book.productservice.view.model.ProductDto;

@Service
public interface IProductValidation {

    Product validateProduct(final String productId);

    ProductDto validateProduct(final ProductDto productDto);

    Product validateProduct(final Product product);

}
