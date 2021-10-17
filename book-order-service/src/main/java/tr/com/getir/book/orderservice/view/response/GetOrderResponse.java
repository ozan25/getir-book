package tr.com.getir.book.orderservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.orderservice.view.model.OrderDto;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "GetOrderResponse", description = "Response object for get order service")
public class GetOrderResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 6824996459355576958L;

    @ApiModelProperty(value = "order", dataType = "OrderDto")
    OrderDto order;
}
