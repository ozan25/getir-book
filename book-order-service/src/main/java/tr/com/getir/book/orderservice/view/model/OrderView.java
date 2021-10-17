package tr.com.getir.book.orderservice.view.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrderView", description = "Order output view")
public class OrderView implements Serializable {

    @Serial
    private static final long serialVersionUID = -4601111524700904501L;

    private OrderDto order;

    private List<OrderDetailDto> orderDetails;
}
