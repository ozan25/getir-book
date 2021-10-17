package tr.com.getir.book.orderdomain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.com.getir.book.orderdomain.entity.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    Optional<Order> findById(String id);

    Optional<List<Order>> findByCustomerId(String customerId);

    Optional<List<Order>> findByProductId(String customerId);

}
