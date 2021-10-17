package tr.com.getir.book.orderdomain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tr.com.getir.book.commondomain.AuditingEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "orderDetail")
public class OrderDetail extends AuditingEntity {

    @Id
    private String id;
    private String orderId;
    private String productId;
    private Long numberOfProduct;

}
