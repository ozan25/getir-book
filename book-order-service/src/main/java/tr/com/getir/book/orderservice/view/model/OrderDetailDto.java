package tr.com.getir.book.orderservice.view.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.commondomain.AuditingDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrderDetailDto", description = "Order detail object")
public class OrderDetailDto extends AuditingDto {

    @Serial
    private static final long serialVersionUID = 7044298171541408940L;

    @ApiModelProperty(value = "Order detail id", dataType = "String", hidden = true)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Order id", dataType = "String", hidden = true)
    private String orderId;

    @NotNull
    @ApiModelProperty(value = "product id", dataType = "String", example = "616c3f8ba44b0a7e5b304d39")
    private String productId;

    @NotNull
    @ApiModelProperty(value = "Number of product", dataType = "Long", example = "2")
    private Long numberOfProduct;

    @NotNull
    @ApiModelProperty(value = "total price", dataType = "BigDecimal", example = "250")
    private BigDecimal totalPrice;
}
