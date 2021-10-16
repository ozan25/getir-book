package tr.com.getir.book.customerdomain.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.repository.dao.AddressDao;

@Component
public class AddressDaoImpl implements AddressDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insert(Address address) {
        mongoTemplate.insert(address);
    }
}
