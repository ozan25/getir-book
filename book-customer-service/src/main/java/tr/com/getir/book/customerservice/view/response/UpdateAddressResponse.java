package tr.com.getir.book.customerservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.customerservice.view.model.AddressDto;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UpdateAddressResponse", description = "Response object for update address service")
public class UpdateAddressResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8177525809986152910L;

    @ApiModelProperty(value = "adress", dataType = "AddressDto")
    private AddressDto address;
}
