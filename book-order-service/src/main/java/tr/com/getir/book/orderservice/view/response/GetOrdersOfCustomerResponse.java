package tr.com.getir.book.orderservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.orderservice.view.model.OrderView;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GetOrdersOfCustomerResponse", description = "Response object for get orders of customer service")
public class GetOrdersOfCustomerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -2627157736314152568L;

    @ApiModelProperty(value = "orderViews", dataType = "List<OrderView>")
    List<OrderView> orderviews;
}
