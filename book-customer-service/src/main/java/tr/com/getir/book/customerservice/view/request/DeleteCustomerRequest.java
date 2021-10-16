package tr.com.getir.book.customerservice.view.request;

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
@ApiModel(value = "DeleteCustomerRequest", description = "Request object for delete customer service")
public class DeleteCustomerRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 672398454860277174L;

    @NotNull
    private String customerId;

}
