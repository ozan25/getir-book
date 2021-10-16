package tr.com.getir.book.customerservice.view.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "GetCustomerResponse", description = "Response object for get-customer service")
public class GetCustomerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -4078012072830299449L;

    @ApiModelProperty(value = "Name", dataType = "String", example = "Ozan")
    private String name;

    @ApiModelProperty(value = "Sur name", dataType = "String", example = "Yakupoğlu")
    private String surName;

    @ApiModelProperty(value = "Email", dataType = "String", example = "ozanemrah@outlook.com")
    private String email;
}
