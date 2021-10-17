package tr.com.getir.book.productdomain.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import tr.com.getir.book.productdomain.entity.Stock;
import tr.com.getir.book.productdomain.repository.dao.IStockDao;

@Component
public class StockDao implements IStockDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(Stock stock) {
        mongoTemplate.insert(stock);
    }

    @Override
    public void update(Stock stock) {
        mongoTemplate.save(stock);
    }

    @Override
    public void delete(Stock stock) {
        mongoTemplate.remove(stock);
    }
}
