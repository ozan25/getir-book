package tr.com.getir.book.exception.constant;

public enum ExceptionCode implements IExceptionCode {

    INTERNAL_ERROR("GB-0000", "Internal error");

    private String code;
    private String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

}
