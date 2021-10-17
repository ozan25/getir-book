package tr.com.getir.book.orderdomain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tr.com.getir.book.commondomain.AuditingEntity;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "order")
public class Order extends AuditingEntity {
    @Id
    private String id;
    private String customerId;
    private String addressId;
    private String status;
    private Date deliveryStartDate;
    private Date deliveryFinishDate;
    private String detail;
}
