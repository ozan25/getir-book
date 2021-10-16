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
@ApiModel(value = "UpdateAddressResponse", description = "Response object for update address service")
public class UpdateAddressResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8177525809986152910L;

    @ApiModelProperty(value = "Id", dataType = "String", example = "123456")
    private String id;
}
