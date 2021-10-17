package tr.com.getir.book.productservice.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.productdomain.entity.Stock;
import tr.com.getir.book.productdomain.repository.StockRepository;
import tr.com.getir.book.productservice.validation.IStockValidation;
import tr.com.getir.book.productservice.view.model.StockDto;
import tr.com.getir.book.util.Util;

public class StockValidation implements IStockValidation {

    @Autowired
    private StockRepository repository;

    @Override
    public Stock validateStock(String stockId) {
        if (Util.isEmpty(stockId)) {
            throw new RequestException(ExceptionCode.STOCK_NOT_FOUND);
        }
        Stock stock = repository.findById(stockId).orElse(null);
        if (Util.isEmpty(stockId)) {
            throw new BusinessException(ExceptionCode.STOCK_NOT_FOUND);
        }
        return stock;
    }

    @Override
    public StockDto validateStock(StockDto stockDto) {
        if (Util.isEmpty(stockDto)) {
            throw new RequestException(ExceptionCode.STOCK_NOT_FOUND);
        }
        return stockDto;
    }

    @Override
    public Stock validateStock(Stock stock) {
        if (Util.isEmpty(stock)) {
            throw new RequestException(ExceptionCode.STOCK_NOT_FOUND);
        }
        return stock;
    }
}
