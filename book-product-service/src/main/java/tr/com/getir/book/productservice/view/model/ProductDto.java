package tr.com.getir.book.productservice.view.model;

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
@ApiModel(value = "ProductDto", description = "Product object")
public class ProductDto extends AuditingDto {

    @Serial
    private static final long serialVersionUID = -5506307750801784116L;

    @ApiModelProperty(value = "Product id", dataType = "String")
    private String id;

    @NotNull
    @ApiModelProperty(value = "Product type", dataType = "String", example = "KITAP")
    private String productType;

    @NotNull
    @ApiModelProperty(value = "Name", dataType = "String", example = "Algoritmalar")
    private String name;

    @NotNull
    @ApiModelProperty(value = "Brand", dataType = "String", example = "Seçkin")
    private String brand;

    @NotNull
    @ApiModelProperty(value = "Author", dataType = "String", example = "Vasif Vagifoğlu")
    private String author;

    @NotNull
    @ApiModelProperty(value = "Price", dataType = "BigDecimal", example = "150.00")
    private String price;

    @NotNull
    @ApiModelProperty(value = "Detail", dataType = "String", example = "Algoritma kitabı")
    private String detail;
}
