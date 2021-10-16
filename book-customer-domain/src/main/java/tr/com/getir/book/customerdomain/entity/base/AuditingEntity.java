package tr.com.getir.book.customerdomain.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Size(min = 1, max = 200)
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private Instant createdDate;
	
	@Size(max = 200)
	@LastModifiedBy
	private String lastModifiedBy;
	
	@LastModifiedDate
	private Instant lastModifiedDate;
	
}
