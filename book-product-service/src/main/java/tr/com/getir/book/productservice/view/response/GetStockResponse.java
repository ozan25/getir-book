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
@ApiModel(value = "GetStockResponse", description = "Response object for get stock service")
public class GetStockResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 9092441479763685194L;

    @ApiModelProperty(value = "stock", dataType = "StockDto")
    StockDto stock;
}
