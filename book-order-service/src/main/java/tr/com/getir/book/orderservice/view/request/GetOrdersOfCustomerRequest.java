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
@ApiModel(value = "GetOrdersOfCustomerRequest", description = "Request object for get order of customers service")
public class GetOrdersOfCustomerRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -4931220710337722992L;

    @NotNull
    @ApiModelProperty(value = "Order id", dataType = "String", example = "616c443eb61d6f7595e25342", required = true)
    private String customerId;

    @ApiModelProperty(value = "Order id", dataType = "String", example = "616c704f65f2116a69638aa2")
    private String orderId;

    @ApiModelProperty(value = "Order id", dataType = "String", example = "ON_DELIVERY")
    private String status;


}
