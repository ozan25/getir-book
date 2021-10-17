package tr.com.getir.book.customerservice.view.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.customerservice.view.model.AddressDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CreateAddressRequest", description = "Request object for create address service")
public class CreateAddressRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -6609648939065898834L;

    @NotNull
    @ApiModelProperty(value = "Customer id", dataType = "String", example="616c5ca24f917a7f15709638")
    private String customerId;

    @NotNull
    private AddressDto address;

}
