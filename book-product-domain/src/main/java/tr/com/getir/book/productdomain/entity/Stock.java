package tr.com.getir.book.productdomain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tr.com.getir.book.commondomain.AuditingEntity;

import java.io.Serial;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Document(collection = "stock")
public class Stock extends AuditingEntity {
    @Serial
    private static final long serialVersionUID = -4284801740751775135L;

    @Id
    private String id;
    private String productId;
    private Long inWarehouseCount;
    private Long onDeliveryCount;
}
