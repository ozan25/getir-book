package tr.com.getir.book.customerdomain.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.dao.CustomerDao;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insert(Customer customer) {
        mongoTemplate.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        mongoTemplate.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        mongoTemplate.remove(customer);
    }
}
