package tr.com.getir.book.orderdomain.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import tr.com.getir.book.orderdomain.entity.OrderDetail;
import tr.com.getir.book.orderdomain.repository.dao.IOrderDetailDao;

@Component
public class OrderDetailDao implements IOrderDetailDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(OrderDetail orderDetail) {
        mongoTemplate.insert(orderDetail);
    }

    @Override
    public void update(OrderDetail orderDetail) {
        mongoTemplate.save(orderDetail);
    }

    @Override
    public void delete(OrderDetail orderDetail) {
        mongoTemplate.remove(orderDetail);
    }
}
