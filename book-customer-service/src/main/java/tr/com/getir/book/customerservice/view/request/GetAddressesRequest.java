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
@ApiModel(value = "GetAddressesRequest", description = "Request object for get addresses service")
public class GetAddressesRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 560132823110701745L;

    @NotNull
    private String customerId;

}
