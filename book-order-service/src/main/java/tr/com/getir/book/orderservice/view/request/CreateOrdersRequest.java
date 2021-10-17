package tr.com.getir.book.orderservice.view.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.orderservice.view.model.OrderDetailDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CreateOrdersRequest", description = "Request object for create order service")
public class CreateOrdersRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7972868299799300218L;

    @NotNull
    private List<OrderDetailDto> orderDetails;

    @NotNull
    @ApiModelProperty(value = "Customer id", dataType = "String", example = "616c5ca24f917a7f15709638")
    private String customerId;

    @NotNull
    @ApiModelProperty(value = "Address id", dataType = "String", example = "616c9ad48014af064526ac9b")
    private String addressId;


}
