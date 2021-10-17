package tr.com.getir.book.customerservice.view.request;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "UpdateAddressRequest", description = "Request object for update address service")
public class UpdateAddressRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 6923392854850745042L;

    @NotNull
    private AddressDto address;

}
