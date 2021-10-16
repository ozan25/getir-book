package tr.com.getir.book.customerdomain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tr.com.getir.book.commondomain.AuditingEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "address")
public class Address extends AuditingEntity {
    @Id
    private String id;
    @DBRef(lazy = true)
    private Customer customer;
    private String name;
    private String country;
    private String city;
    private String town;
    private String detail;
}
