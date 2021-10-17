package tr.com.getir.book.productservice.data;

import org.springframework.stereotype.Service;
import tr.com.getir.book.productdomain.entity.Stock;

import java.util.Optional;

@Service
public interface IStockDataService {

    Optional<Stock> findByProductId(String productId);

}
