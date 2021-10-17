package tr.com.getir.book.productservice.view.request;

import io.swagger.annotations.ApiModel;
import lombok.*;
import tr.com.getir.book.productservice.view.model.ProductDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "UpdateProductRequest", description = "Request object for update product service")
public class UpdateProductRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -3921050049295783536L;

    @NotNull
    private ProductDto product;

}
