package tr.com.getir.book.productservice.converter;

import org.springframework.stereotype.Component;
import tr.com.getir.book.commonservice.converter.BaseConverter;
import tr.com.getir.book.productdomain.entity.Stock;
import tr.com.getir.book.productservice.view.model.StockDto;

@Component
public class StockConverter extends BaseConverter<StockDto, Stock> {
    @Override
    protected Class<StockDto> getDtoClass() {
        return StockDto.class;
    }

    @Override
    protected Class<Stock> getEntityClass() {
        return Stock.class;
    }
}
