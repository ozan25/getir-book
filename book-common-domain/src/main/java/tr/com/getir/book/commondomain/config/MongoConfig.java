package tr.com.getir.book.commondomain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import tr.com.getir.book.commondomain.Auditor;

/**
 * @author Ozan Emrah Yakupoğlu
 */
@Configuration
@EnableMongoAuditing
public class MongoConfig {

    @Bean
    public AuditorAware<String> auditor() {
        return new Auditor();
    }

}