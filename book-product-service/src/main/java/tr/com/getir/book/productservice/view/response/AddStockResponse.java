package tr.com.getir.book.productservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.productservice.view.model.StockDto;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "AddStockResponse", description = "Response object for add stock service")
public class AddStockResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 2761216389982920568L;

    @ApiModelProperty(value = "stock", dataType = "StockDto")
    StockDto stock;
}
