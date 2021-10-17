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
@ApiModel(value = "WarehouseToDeliveryResponse", description = "Response object for warehouse to delivery service")
public class WarehouseToDeliveryResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -390128686873499423L;

    @ApiModelProperty(value = "stocks", dataType = "StockDto")
    StockDto stocks;
}
