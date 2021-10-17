package tr.com.getir.book.commondomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditingDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1106311912666582373L;

    @ApiModelProperty(hidden = true)
    private String createdBy;
    @ApiModelProperty(hidden = true)
    private Date createdDate;
    @ApiModelProperty(hidden = true)
    private String lastModifiedBy;
    @ApiModelProperty(hidden = true)
    private Date lastModifiedDate;

}
