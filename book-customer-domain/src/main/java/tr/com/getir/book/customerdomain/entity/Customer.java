package tr.com.getir.book.customerdomain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String surName;
}
