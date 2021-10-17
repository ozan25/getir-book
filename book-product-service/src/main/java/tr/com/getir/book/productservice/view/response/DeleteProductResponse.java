package tr.com.getir.book.productservice.view.response;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "DeleteProductResponse", description = "Response object for delete product service")
public class DeleteProductResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 9145409046049686329L;
}
