package tr.com.getir.book.exception;

import tr.com.getir.book.exception.base.BaseException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.exception.constant.ExceptionType;
import tr.com.getir.book.exception.constant.IExceptionCode;

public class RequestException extends BaseException {

    public RequestException() {
        super(ExceptionCode.INTERNAL_ERROR, ExceptionType.REQUEST);
    }

    public RequestException(IExceptionCode exceptionCode) {
        super(exceptionCode, ExceptionType.REQUEST);
    }
}
