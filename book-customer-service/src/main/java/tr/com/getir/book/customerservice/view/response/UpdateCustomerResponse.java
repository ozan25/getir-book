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
@EqualsAndHashCode
@ApiModel(value = "UpdateCustomerResponse", description = "Response object for update customer service")
public class UpdateCustomerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -1470948205290972648L;

    @ApiModelProperty(value = "customer", dataType = "CustomerDto")
    private CustomerDto customer;
}
