package tr.com.getir.book.orderservice.validation;

import tr.com.getir.book.orderdomain.entity.Order;

public interface IOrderValidation {

    Order validateOrder(final String orderId);

}
