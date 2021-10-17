package tr.com.getir.book.productservice.view.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "Product id", dataType = "String", example = "616c3f8ba44b0a7e5b304d39")
    private String productId;

    @NotNull
    @ApiModelProperty(value = "sold Product Number", dataType = "String", example = "2")
    private Long soldProductNumber;

}
