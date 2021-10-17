package tr.com.getir.book.customerdomain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.getir.book.customerdomain.entity.Customer;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findById(String id);

    Optional<List<Customer>> findByName(String name);

}
