package tr.com.getir.book.orderservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.orderservice.view.model.OrderDetailDto;
import tr.com.getir.book.orderservice.view.model.OrderDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CompleteOrderResponse", description = "Response object for complete order service")
public class CompleteOrderResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -5337673982954679126L;

    @ApiModelProperty(value = "Order", dataType = "OrderDto")
    OrderDto order;

    @ApiModelProperty(value = "Order detail", dataType = "OrderDetailDto")
    List<OrderDetailDto> orderDetails;
}
