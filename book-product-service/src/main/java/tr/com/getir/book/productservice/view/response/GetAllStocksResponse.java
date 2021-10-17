package tr.com.getir.book.productservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.productservice.view.model.StockDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GetAllStocksResponse", description = "Response object for get all stocks service")
public class GetAllStocksResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 3170509576454362716L;

    @ApiModelProperty(value = "stocks", dataType = "List<StockDto>")
    List<StockDto> stocks;
}
