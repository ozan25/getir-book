package tr.com.getir.book.customerdomain.repository.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.repository.AddressRepository;
import tr.com.getir.book.customerdomain.repository.dao.AddressDao;
import tr.com.getir.book.util.Util;

import java.util.List;
import java.util.Optional;

@Component
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Address address) {
        mongoTemplate.insert(address);
    }

    @Override
    public void update(Address address) {
        mongoTemplate.save(address);
    }

    @Override
    public void delete(Address address) {
        mongoTemplate.remove(address);
    }

}
