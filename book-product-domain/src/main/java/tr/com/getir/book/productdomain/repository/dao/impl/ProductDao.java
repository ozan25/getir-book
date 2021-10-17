package tr.com.getir.book.productdomain.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import tr.com.getir.book.productdomain.entity.Product;
import tr.com.getir.book.productdomain.repository.dao.IProductDao;

@Component
public class ProductDao implements IProductDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(Product product) {
        mongoTemplate.insert(product);
    }

    @Override
    public void update(Product product) {
        mongoTemplate.save(product);
    }

    @Override
    public void delete(Product product) {
        mongoTemplate.remove(product);
    }
}
