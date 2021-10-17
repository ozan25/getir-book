package tr.com.getir.book.productservice.validation;


import org.springframework.stereotype.Service;
import tr.com.getir.book.productdomain.entity.Stock;
import tr.com.getir.book.productservice.view.model.StockDto;

public interface IStockValidation {

    Stock validateStock(final String stockId);

    StockDto validateStock(final StockDto stockDto);

    Stock validateStock(final Stock stock);

}
