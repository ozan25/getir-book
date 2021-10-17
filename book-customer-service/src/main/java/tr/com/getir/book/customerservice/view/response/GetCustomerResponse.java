package tr.com.getir.book.customerservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.customerservice.view.model.CustomerDto;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GetCustomerResponse", description = "Response object for get-customer service")
public class GetCustomerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -4078012072830299449L;

    @ApiModelProperty(value = "customer", dataType = "CustomerDto")
    private CustomerDto customerDto;
}
