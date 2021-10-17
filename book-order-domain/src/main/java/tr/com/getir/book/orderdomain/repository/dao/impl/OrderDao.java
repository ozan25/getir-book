package tr.com.getir.book.orderdomain.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import tr.com.getir.book.orderdomain.entity.Order;
import tr.com.getir.book.orderdomain.repository.dao.IOrderDao;

@Component
public class OrderDao implements IOrderDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(Order order) {
        mongoTemplate.insert(order);
    }

    @Override
    public void update(Order order) {
        mongoTemplate.save(order);
    }

    @Override
    public void delete(Order order) {
        mongoTemplate.remove(order);
    }
}
