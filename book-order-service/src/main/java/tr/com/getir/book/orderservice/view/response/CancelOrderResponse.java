package tr.com.getir.book.orderservice.view.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CancelOrderResponse", description = "Response object for cancel order service")
public class CancelOrderResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -7430371977800337166L;
}
