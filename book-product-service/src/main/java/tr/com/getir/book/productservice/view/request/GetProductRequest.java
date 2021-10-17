package tr.com.getir.book.productservice.view.request;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "GetProductRequest", description = "Request object for get product service")
public class GetProductRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -5854905224887629284L;

    @NotNull
    private String productId;

}
