package tr.com.getir.book.productservice.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.productdomain.entity.Stock;
import tr.com.getir.book.productdomain.repository.StockRepository;
import tr.com.getir.book.productservice.validation.IStockValidation;
import tr.com.getir.book.util.Util;

@Component
public class StockValidation implements IStockValidation {

    @Autowired
    private StockRepository repository;

    @Override
    public Stock validateStock(Stock stock) {
        if (Util.isEmpty(stock)) {
            throw new BusinessException(ExceptionCode.STOCK_NOT_FOUND);
        }
        return stock;
    }
}
