package tr.com.getir.book.customerservice.view.request;

import io.swagger.annotations.ApiModel;
import lombok.*;
import tr.com.getir.book.customerservice.view.model.AddressDto;
import tr.com.getir.book.customerservice.view.model.CustomerDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CreateCustomerRequest", description = "Request object for create customer service")
public class CreateCustomerRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5622820067551104653L;

    @NotNull
    private CustomerDto customer;

    private List<AddressDto> addresses;

}
