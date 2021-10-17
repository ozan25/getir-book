package tr.com.getir.book.orderservice.view.request;

import io.swagger.annotations.ApiModel;
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
    private String customerId;

    @NotNull
    private String addressId;


}
