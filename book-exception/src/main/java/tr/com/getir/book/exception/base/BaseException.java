package tr.com.getir.book.exception.base;


import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.exception.constant.ExceptionType;
import tr.com.getir.book.exception.constant.IExceptionCode;

public class BaseException extends RuntimeException {
    IExceptionCode exceptionCode;
    ExceptionType exceptionType;

    public BaseException() {
        this.exceptionCode = ExceptionCode.INTERNAL_ERROR;
        exceptionType = ExceptionType.SYSTEM;
    }

    public BaseException(IExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
        exceptionType = ExceptionType.SYSTEM;
    }

    public BaseException(IExceptionCode exceptionCode, ExceptionType exceptionType) {
        this.exceptionCode = exceptionCode;
        this.exceptionType = exceptionType;
    }

}