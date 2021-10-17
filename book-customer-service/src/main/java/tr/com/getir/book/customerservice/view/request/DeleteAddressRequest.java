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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "DeleteAddressRequest", description = "Request object for delete address service")
public class DeleteAddressRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7989277248457748153L;

    @NotNull
    private String addressId;

}
