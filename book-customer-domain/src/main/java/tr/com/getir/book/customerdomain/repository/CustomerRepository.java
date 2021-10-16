package tr.com.getir.book.customerdomain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.dao.CustomerDao;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findById(String id);

    Optional<List<Customer>> findByName(String name);

}
