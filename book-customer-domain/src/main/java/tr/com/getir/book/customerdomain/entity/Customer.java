package tr.com.getir.book.customerdomain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tr.com.getir.book.commondomain.AuditingEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Document(collection = "customer")
public class Customer extends AuditingEntity {
    @Id
    private String id;
    private String username;
    private String password;
    private String name;
    private String surName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String birthday;

}
