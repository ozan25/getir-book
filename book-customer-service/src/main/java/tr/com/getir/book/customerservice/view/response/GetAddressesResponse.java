package tr.com.getir.book.customerservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.customerservice.view.model.AddressDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GetAddressesResponse", description = "Response object for get addresses service")
public class GetAddressesResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1313769802260179963L;

    @ApiModelProperty(value = "Id", dataType = "String", example = "123456")
    private List<AddressDto> addresses;
}
