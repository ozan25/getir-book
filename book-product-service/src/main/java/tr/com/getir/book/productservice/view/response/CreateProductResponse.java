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
@ApiModel(value = "CreateProductResponse", description = "Response object for create product service")
public class CreateProductResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 5026948411187986764L;

    @ApiModelProperty(value = "product", dataType = "ProductDto")
    private ProductDto product;
}
