package tr.com.getir.book.exception;

import tr.com.getir.book.exception.base.BaseException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.exception.constant.ExceptionType;
import tr.com.getir.book.exception.constant.IExceptionCode;

public class BusinessException extends BaseException {

    public BusinessException() {
        super(ExceptionCode.INTERNAL_ERROR, ExceptionType.BUSINESS);
    }

    public BusinessException(IExceptionCode exceptionCode) {
        super(exceptionCode, ExceptionType.BUSINESS);
    }
}
