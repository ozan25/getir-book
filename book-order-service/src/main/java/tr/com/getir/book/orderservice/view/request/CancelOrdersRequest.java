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
@EqualsAndHashCode
@ApiModel(value = "CancelOrdersRequest", description = "Request object for cancel order service")
public class CancelOrdersRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7639178102336094538L;

    @NotNull
    private String orderId;


}