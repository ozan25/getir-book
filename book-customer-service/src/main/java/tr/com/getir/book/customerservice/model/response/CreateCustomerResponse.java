package tr.com.getir.book.customerservice.model.response;

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
@ApiModel(value = "CreateCustomerResponse", description = "Response object for create customer service")
public class CreateCustomerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -4078012072830299449L;

    @ApiModelProperty(value = "Id", dataType = "Long", example = "123456")
    private Long id;
}
