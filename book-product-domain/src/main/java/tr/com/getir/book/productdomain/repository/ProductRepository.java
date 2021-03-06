package tr.com.getir.book.productdomain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.getir.book.productdomain.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findById(String id);

    Optional<List<Product>> findByName(String id);

}
