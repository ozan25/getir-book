package tr.com.getir.book.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = {"tr.com.getir.book.*"})
public class GetirBookApplication {

    public static void main(String[] args) {
        System.out.println("GetirBook application is starting at " + new Date());
        SpringApplication.run(GetirBookApplication.class, args);
        System.out.println("GetirBook application is started at " + new Date());
    }

}
