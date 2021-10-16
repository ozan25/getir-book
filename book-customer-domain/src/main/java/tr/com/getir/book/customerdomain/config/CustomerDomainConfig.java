package tr.com.getir.book.customerdomain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Ozan Emrah Yakupoğlu
 */
@Configuration
@EnableMongoRepositories(basePackages = {"tr.com.getir.book.customerdomain.repository"})
public class CustomerDomainConfig {
}