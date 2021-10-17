package tr.com.getir.book.orderservice.view.request;

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
@ApiModel(value = "CompleteOrdersRequest", description = "Request object for complete order service")
public class CompleteOrdersRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 6630772896852514572L;

    @NotNull
    @ApiModelProperty(value = "Order id", dataType = "String", example = "616c4750b61d6f7595e25346")
    private String orderId;


}
