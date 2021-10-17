package tr.com.getir.book.productdomain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Ozan Emrah Yakupoğlu
 */
@Configuration
@EnableMongoRepositories(basePackages = {"tr.com.getir.book.productdomain.repository"})
public class ProductDomainConfig {
}