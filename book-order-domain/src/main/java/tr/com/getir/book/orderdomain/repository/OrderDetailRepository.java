package tr.com.getir.book.orderdomain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.getir.book.orderdomain.entity.OrderDetail;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OrderDetailRepository extends MongoRepository<OrderDetail, String> {

    Optional<OrderDetail> findById(String id);

    Optional<List<OrderDetail>> findByOrderId(String orderId);

}
