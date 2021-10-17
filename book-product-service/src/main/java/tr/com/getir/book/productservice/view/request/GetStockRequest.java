package tr.com.getir.book.productservice.view.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GetStockRequest", description = "Request object for get stock service")
public class GetStockRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1483862705281372186L;

    @NotNull
    @ApiModelProperty(value = "Product id", dataType = "String", example = "616c3f8ba44b0a7e5b304d39")
    private String productId;

}
