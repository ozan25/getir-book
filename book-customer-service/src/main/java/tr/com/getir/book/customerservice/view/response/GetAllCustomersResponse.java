package tr.com.getir.book.customerservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.customerservice.view.model.CustomerDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "GetCustomerResponse", description = "Response object for get-customer service")
public class GetAllCustomersResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -4078012072830299449L;

    @ApiModelProperty(value = "customer", dataType = "Customer Dto")
    private List<CustomerDto> customers;
}
