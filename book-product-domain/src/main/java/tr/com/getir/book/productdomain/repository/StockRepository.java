package tr.com.getir.book.productdomain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.getir.book.productdomain.entity.Stock;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface StockRepository extends MongoRepository<Stock, String> {

    Optional<Stock> findById(String id);

    Optional<Stock> findByProductId(String productId);

}
