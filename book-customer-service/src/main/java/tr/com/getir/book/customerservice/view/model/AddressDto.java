package tr.com.getir.book.customerservice.view.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tr.com.getir.book.commondomain.AuditingDto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "AddressDto", description = "Address object")
public class AddressDto extends AuditingDto {

    @Serial
    private static final long serialVersionUID = -5506307750801784116L;

    @ApiModelProperty(value = "Address id", dataType = "String")
    private String id;

    @NotNull
    @ApiModelProperty(value = "Address name", dataType = "String", example = "Ev")
    private String name;

    @NotNull
    @ApiModelProperty(value = "Country", dataType = "String", example = "Türkiye")
    private String country;

    @NotNull
    @ApiModelProperty(value = "City", dataType = "String", example = "İstanbul")
    private String city;

    @NotNull
    @ApiModelProperty(value = "town", dataType = "String", example = "Maltepe")
    private String town;

    @NotNull
    @ApiModelProperty(value = "Other address information", dataType = "String", example = "Küçükyalı mah. 5/6")
    private String detail;
}
