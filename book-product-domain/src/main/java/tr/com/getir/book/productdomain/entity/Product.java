package tr.com.getir.book.productdomain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import tr.com.getir.book.commondomain.AuditingEntity;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "product")
public class Product extends AuditingEntity {
    @Id
    private String id;
    private String productType;
    private String name;
    private String brand;
    private String author;
    private BigDecimal price;
    private String detail;
}
