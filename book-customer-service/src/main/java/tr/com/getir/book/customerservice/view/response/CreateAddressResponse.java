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
@EqualsAndHashCode
@ApiModel(value = "CreateAddressResponse", description = "Response object for create address service")
public class CreateAddressResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -5212151786414806561L;

    @ApiModelProperty(value = "address", dataType = "AddressDto")
    private AddressDto address;
}
