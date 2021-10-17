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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UpdateDeliveryStockRequest", description = "Request object for update delivery stock service")
public class UpdateDeliveryStockRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 173489123518110333L;

    @NotNull
    private String productId;

    @NotNull
    private Long soldProductNumber;

}
