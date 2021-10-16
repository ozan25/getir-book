package tr.com.getir.book.customerservice.view.request;

import io.swagger.annotations.ApiModel;
import lombok.*;
import tr.com.getir.book.customerservice.view.model.CustomerDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "UpdateCustomerRequest", description = "Request object for update customer service")
public class UpdateCustomerRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 259352279749739322L;

    @NotNull
    private CustomerDto customer;

}
