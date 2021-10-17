package tr.com.getir.book.orderdomain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tr.com.getir.book.commondomain.AuditingEntity;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Document(collection = "orderDetail")
public class OrderDetail extends AuditingEntity {

    @Id
    private String id;
    private String orderId;
    private String productId;
    private Long numberOfProduct;
    private BigDecimal totalPrice;

}
