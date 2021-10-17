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
@ApiModel(value = "GetOrderRequest", description = "Request object for get order service")
public class GetOrderRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 8032242670529109004L;

    @NotNull
    private String orderId;


}
