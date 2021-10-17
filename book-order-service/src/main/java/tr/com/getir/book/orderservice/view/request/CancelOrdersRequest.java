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
@ApiModel(value = "CancelOrdersRequest", description = "Request object for cancel order service")
public class CancelOrdersRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7639178102336094538L;

    @NotNull
    @ApiModelProperty(value = "Order id", dataType = "String", example = "616c4750b61d6f7595e25346")
    private String orderId;


}
