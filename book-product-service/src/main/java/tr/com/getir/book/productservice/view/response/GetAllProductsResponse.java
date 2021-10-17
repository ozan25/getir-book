package tr.com.getir.book.productservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.productservice.view.model.ProductDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GetAllProductsResponse", description = "Response object for get all products service")
public class GetAllProductsResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 6167513326353195259L;

    @ApiModelProperty(value = "products", dataType = "List<ProductDto>")
    private List<ProductDto> products;
}
