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
@EqualsAndHashCode
@ApiModel(value = "CustomerDto", description = "Customer object")
public class CustomerDto extends AuditingDto {

    @Serial
    private static final long serialVersionUID = 5622820067551104653L;

    @ApiModelProperty(value = "Customer id", dataType = "String", example = "123456")
    private String id;

    @NotNull
    @ApiModelProperty(value = "Customer username", dataType = "String", required = true, example = "ozanemrah123")
    private String username;

    @NotNull
    @ApiModelProperty(value = "Customer password", dataType = "String", required = true, example = "Abc123")
    private String password;

    @NotNull
    @ApiModelProperty(value = "Customer name", dataType = "String", required = true, example = "Ozan")
    private String name;

    @NotNull
    @ApiModelProperty(value = "Customer surname", dataType = "String", required = true, example = "Yakupoğlu")
    private String surName;

    @ApiModelProperty(value = "Customer gender", dataType = "String", example = "Male")
    private String gender;

    @NotNull
    @ApiModelProperty(value = "Customer email", dataType = "String", required = true, example = "ozanemrah@outlook.com")
    private String email;

    @NotNull
    @ApiModelProperty(value = "Customer phoneNumber", dataType = "String", required = true, example = "5332109590")
    private String phoneNumber;

    @ApiModelProperty(value = "Customer birthday", dataType = "String", example = "04.08.1991")
    private String birthday;

}
