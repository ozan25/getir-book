package tr.com.getir.book.productservice.converter;

import org.springframework.stereotype.Component;
import tr.com.getir.book.commonservice.converter.BaseConverter;
import tr.com.getir.book.productdomain.entity.Product;
import tr.com.getir.book.productservice.view.model.ProductDto;

@Component
public class ProductConverter extends BaseConverter<ProductDto, Product> {
    @Override
    protected Class<ProductDto> getDtoClass() {
        return ProductDto.class;
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }
}
