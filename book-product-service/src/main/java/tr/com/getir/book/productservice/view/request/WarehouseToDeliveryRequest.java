package tr.com.getir.book.productservice.view.request;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "WarehouseToDeliveryRequest", description = "Request object for warehouse to delivery service")
public class WarehouseToDeliveryRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -6583052545608008856L;

    @NotNull
    private String productId;

    @NotNull
    private Long numberOfProducts;

}
