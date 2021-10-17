package tr.com.getir.book.productservice.view.request;

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
@ApiModel(value = "AddStockRequest", description = "Request object for add stock service")
public class AddStockRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -6583052545608008856L;

    @NotNull
    private String productId;

    @NotNull
    private Long numberOfProduct;

}
