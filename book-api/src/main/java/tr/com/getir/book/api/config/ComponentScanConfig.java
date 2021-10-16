package tr.com.getir.book.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"tr.com.getir.book.api.*"})
public class ComponentScanConfig {
}
