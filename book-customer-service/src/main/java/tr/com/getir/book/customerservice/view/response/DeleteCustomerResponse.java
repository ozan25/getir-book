package tr.com.getir.book.customerservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "DeleteCustomerResponse", description = "Response object for delete customer service")
public class DeleteCustomerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -1586407137454252223L;

}
