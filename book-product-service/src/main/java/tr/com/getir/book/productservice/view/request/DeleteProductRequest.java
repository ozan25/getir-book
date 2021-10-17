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
@ApiModel(value = "DeleteProductRequest", description = "Request object for delete product service")
public class DeleteProductRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 2165632522694533103L;

    @NotNull
    private String productId;

}
