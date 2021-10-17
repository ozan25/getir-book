package tr.com.getir.book.productservice.data.impl;


import org.springframework.beans.factory.annotation.Autowired;
import tr.com.getir.book.productdomain.entity.Stock;
import tr.com.getir.book.productdomain.repository.StockRepository;
import tr.com.getir.book.productservice.data.IStockDataService;
import tr.com.getir.book.util.Util;

import java.util.Optional;

public class StockDataService implements IStockDataService {

    @Autowired
    private StockRepository repository;

    @Override
    public Optional<Stock> findByProductId(String productId) {
        if (Util.isNotEmpty(productId)) {
            return repository.findByProductId(productId);
        }
        return null;
    }
}
