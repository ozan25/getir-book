package tr.com.getir.book.exception;

import tr.com.getir.book.exception.base.BaseException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.exception.constant.ExceptionType;
import tr.com.getir.book.exception.constant.IExceptionCode;

public class SystemException extends BaseException {

    public SystemException() {
        super(ExceptionCode.INTERNAL_ERROR, ExceptionType.SYSTEM);
    }

    public SystemException(IExceptionCode exceptionCode) {
        super(exceptionCode, ExceptionType.SYSTEM);
    }
}
