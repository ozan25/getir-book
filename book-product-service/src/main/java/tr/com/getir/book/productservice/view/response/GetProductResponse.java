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
@ApiModel(value = "GetProductResponse", description = "Response object for get product service")
public class GetProductResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -3358207227554132848L;

    @ApiModelProperty(value = "product", dataType = "ProductDto")
    private ProductDto product;
}
