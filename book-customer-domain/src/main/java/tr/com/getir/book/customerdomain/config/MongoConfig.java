package tr.com.getir.book.customerdomain.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Ozan Emrah Yakupoğlu
 */
@Configuration
@EnableMongoRepositories(basePackages = {"tr.com.getir.book.*"})
@Slf4j
public class MongoConfig {

}