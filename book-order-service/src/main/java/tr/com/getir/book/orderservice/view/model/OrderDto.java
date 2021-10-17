package tr.com.getir.book.orderservice.view.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.commondomain.AuditingDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "OrderDto", description = "Order object")
public class OrderDto extends AuditingDto {

    @Serial
    private static final long serialVersionUID = -5506307750801784116L;

    @ApiModelProperty(value = "Order id", dataType = "String")
    private String id;

    @NotNull
    @ApiModelProperty(value = "Csutomer id", dataType = "String")
    private String customerId;

    @NotNull
    @ApiModelProperty(value = "Address id", dataType = "String")
    private String addressId;

    @NotNull
    @ApiModelProperty(value = "status", dataType = "String")
    private String status;

    @NotNull
    @ApiModelProperty(value = "delivery start date", dataType = "Date")
    private Date deliveryStartDate;

    @NotNull
    @ApiModelProperty(value = "delivery finish date", dataType = "Date")
    private Date deliveryFinishDate;

    @NotNull
    @ApiModelProperty(value = "Detail", dataType = "String")
    private String detail;
}
