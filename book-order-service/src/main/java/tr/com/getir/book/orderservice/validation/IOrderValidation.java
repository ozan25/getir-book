package tr.com.getir.book.orderservice.validation;

import org.springframework.stereotype.Service;
import tr.com.getir.book.orderdomain.entity.Order;
import tr.com.getir.book.orderservice.view.model.OrderDto;

public interface IOrderValidation {

    Order validateOrder(final String orderId);

}
