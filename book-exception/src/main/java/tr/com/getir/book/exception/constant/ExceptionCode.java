package tr.com.getir.book.exception.constant;

public enum ExceptionCode implements IExceptionCode {

    INTERNAL_ERROR("GB-0000", "Internal error"),
    CUSTOMER_NOT_FOUND("GB-0001", "Customer not found"),
    ADDRESS_ID_NOT_FOUND("GB-0002", "Address id not found"),
    ADDRESS_NOT_FOUND("GB-0003", "Address not found"),
    CUSTOMER_ID_NOT_FOUND("GB-0004", "Customer id not found"),
    PRODUCT_NOT_FOUND("GB-0005", "Product id not found"),
    PRODUCT_ID_NOT_FOUND("GB-0006", "Product not found"),
    STOCK_NOT_FOUND("GB-0007", "Stock not found"),
    INSUFFICIENT_STOCK("GB-0008", "Insufficient Stock"),
    ORDER_ID_NOT_FOUND("GB-0009", "Order id not found"),
    ORDER_NOT_FOUND("GB-0010", "Order not found"),
    ORDER_CAN_NOT_BE_CANCELED("GB-0011", "The order can not be canceled"),
    ORDER_DETAILS_NOT_FOUND("GB-0012", "Order details not found"),
    STOCK_ID_NOT_FOUND("GB-0013", "Stock id not found"),
    ORDER_CAN_NOT_BE_COMPLETED("GB-0014", "The order can not be completed");

    private String code;
    private String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
