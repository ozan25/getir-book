package tr.com.getir.book.customerdomain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.getir.book.customerdomain.entity.Address;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AddressRepository extends MongoRepository<Address, String> {

    Optional<Address> findById(String id);

    Optional<List<Address>> findByCustomerId(String id);

}
