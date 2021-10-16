package tr.com.getir.book.customerservice.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "CreateCustomerRequest", description = "Request object for create customer service")
public class CreateCustomerRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5622820067551104653L;

    @NotNull
    @ApiModelProperty(value = "Customer name", dataType = "String", required = true, example = "Ozan")
    private String name;

    @NotNull
    @ApiModelProperty(value = "Customer sur name", dataType = "String", required = true, example = "Yakupoğlu")
    private String surName;
}
