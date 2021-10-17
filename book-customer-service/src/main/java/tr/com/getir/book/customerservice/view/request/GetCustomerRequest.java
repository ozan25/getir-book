package tr.com.getir.book.customerservice.view.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GetCustomerRequest", description = "Request object for get-customer service")
public class GetCustomerRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5622820067551104653L;

    @NotNull
    @ApiModelProperty(value = "Customer id", dataType = "String", required = true, example = "123456")
    private String customerId;
}
