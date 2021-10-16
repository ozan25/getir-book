package tr.com.getir.book.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;

@Configuration
public class CorsConfig {
    CorsConfiguration corsConfiguration;

    @PostConstruct
    protected void postCons() {
        this.corsConfiguration = new CorsConfiguration();
        this.corsConfiguration.addAllowedOrigin("*");
        this.corsConfiguration.addAllowedMethod("*");
        this.corsConfiguration.addAllowedHeader("*");
        this.corsConfiguration.addExposedHeader("Authorization,Link,X-Total-Count");
        this.corsConfiguration.setAllowCredentials(false);
        this.corsConfiguration.setMaxAge(1800L);
    }

    @Bean
    public CorsFilter corsFilter() {
        final var source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/security/**", this.corsConfiguration);
        source.registerCorsConfiguration("/api/**", this.corsConfiguration);
        source.registerCorsConfiguration("/management/**", this.corsConfiguration);
        source.registerCorsConfiguration("/v2/api-docs", this.corsConfiguration);
        source.registerCorsConfiguration("/*/api/**", this.corsConfiguration);
        source.registerCorsConfiguration("/services/*/api/**", this.corsConfiguration);
        source.registerCorsConfiguration("/*/management/**", this.corsConfiguration);

        return new CorsFilter(source);
    }

}
