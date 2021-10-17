package tr.com.getir.book.productservice.view.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.commondomain.AuditingDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "StockDto", description = "Stock object")
public class StockDto extends AuditingDto {

    @Serial
    private static final long serialVersionUID = 4994669794887564006L;

    @ApiModelProperty(value = "Stock id", dataType = "String", hidden = true)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Product id", dataType = "String")
    private String productId;

    @NotNull
    @ApiModelProperty(value = "in warehouse count", dataType = "Long")
    private Long inWarehouseCount;

    @NotNull
    @ApiModelProperty(value = "On delivery count", dataType = "Long")
    private String onDeliveryCount;

}
