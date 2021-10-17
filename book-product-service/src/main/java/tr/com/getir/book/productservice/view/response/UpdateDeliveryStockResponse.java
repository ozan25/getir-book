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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UpdateDeliveryStockResponse", description = "Response object for update delivery stock service")
public class UpdateDeliveryStockResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 4472900063752298878L;

    @ApiModelProperty(value = "stock", dataType = "StockDto")
    StockDto stock;
}
