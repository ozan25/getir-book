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
@ApiModel(value = "DeleteAddressResponse", description = "Response object for delete address service")
public class DeleteAddressResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8814470130782894633L;

    @ApiModelProperty(value = "Id", dataType = "String", example = "123456")
    private String id;
}
