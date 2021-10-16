package tr.com.getir.book.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.SystemException;
import tr.com.getir.book.exception.base.BaseException;
import tr.com.getir.book.exception.constant.ExceptionType;
import tr.com.getir.book.util.RequestContext;
import tr.com.getir.book.util.Util;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<?> systemExceptionHandler(SystemException ex, WebRequest request) {
        log.info("systemExceptionHandler started");
        return handle(ex, request, ExceptionType.SYSTEM, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessExceptionHandler(BusinessException ex, WebRequest request) {
        log.info("businessExceptionHandler started");
        return handle(ex, request, ExceptionType.BUSINESS, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<?> requestExceptionHandler(RequestException ex, WebRequest request) {
        log.info("requestExceptionHandler started");
        return handle(ex, request, ExceptionType.SYSTEM, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> baseExceptionHandler(BaseException ex, WebRequest request) {
        log.info("baseExceptionHandler started");
        return handle(ex, request, ExceptionType.SYSTEM, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> throwableHandler(Throwable ex, WebRequest request) {
        log.info("throwableExceptionHandler started");
        return handle(new SystemException(), request, ExceptionType.SYSTEM, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<Object> handle(BaseException e, WebRequest request, ExceptionType exceptionType,
                                            HttpStatus httpStatus) {
        ResponseEntity response;
        try {
            ExceptionResult exceptionResult = new ExceptionResult();
            if (Util.isNotEmpty(e.getExceptionCode())) {
                MDC.put("exceptionCode", e.getExceptionCode().getCode());
                MDC.put("exceptionMessage", e.getExceptionCode().getCode());
                exceptionResult.setCode(e.getExceptionCode().getCode());
                exceptionResult.setMessage(e.getExceptionCode().getMessage());
            }
            MDC.put("exceptionType", e.getExceptionType() != null ? e.getExceptionType().name() : null);
            if (Util.isNotEmpty(httpStatus)) {
                MDC.put("httpResponseCode", String.valueOf(httpStatus.value()));
                MDC.put("httpResponseMessage", httpStatus.name());
                exceptionResult.setHttpStatusCode(String.valueOf(httpStatus.value()));
                exceptionResult.setHttpStatusMessage(httpStatus.name());
            }
            exceptionResult.setExceptionType(e.getExceptionType());
            exceptionResult.setTransactionId(RequestContext.getTransactionId());
            response = new ResponseEntity(exceptionResult, httpStatus);
        } finally {
            MDC.remove("exceptionCode");
            MDC.remove("exceptionMessage");
            MDC.remove("exceptionType");
            MDC.remove("httpResponseCode");
            MDC.remove("httpResponseMessage");
        }
        return response;
    }


}
