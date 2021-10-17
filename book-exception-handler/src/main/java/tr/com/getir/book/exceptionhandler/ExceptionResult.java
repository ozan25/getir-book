package tr.com.getir.book.exceptionhandler;

import lombok.*;
import tr.com.getir.book.exception.constant.ExceptionType;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class ExceptionResult implements Serializable {

    @Serial
    private static final long serialVersionUID = -8569582201014869910L;

    private String code;
    private String message;
    private ExceptionType exceptionType;
    private String httpStatusCode;
    private String httpStatusMessage;
    private Long transactionId;
}
