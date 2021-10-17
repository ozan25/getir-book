package tr.com.getir.book.productservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.productservice.view.model.ProductDto;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UpdateProductResponse", description = "Response object for update product service")
public class UpdateProductResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -7388717447832695675L;

    @ApiModelProperty(value = "product", dataType = "ProductDto")
    private ProductDto product;
}
