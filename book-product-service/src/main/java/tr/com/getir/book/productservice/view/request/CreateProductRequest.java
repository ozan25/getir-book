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
@ApiModel(value = "CreateProductRequest", description = "Request object for create product service")
public class CreateProductRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -6583052545608008856L;

    @NotNull
    private ProductDto product;

}
