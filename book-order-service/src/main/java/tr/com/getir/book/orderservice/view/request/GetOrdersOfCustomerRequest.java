package tr.com.getir.book.orderservice.view.request;

import io.swagger.annotations.ApiModel;
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
    private String customerId;

    private String orderId;

    private String status;


}
