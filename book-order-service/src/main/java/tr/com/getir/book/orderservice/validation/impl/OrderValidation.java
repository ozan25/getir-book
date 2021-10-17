package tr.com.getir.book.orderservice.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.orderdomain.entity.Order;
import tr.com.getir.book.orderdomain.repository.OrderRepository;
import tr.com.getir.book.orderservice.validation.IOrderValidation;
import tr.com.getir.book.orderservice.view.model.OrderDto;
import tr.com.getir.book.util.Util;

@Component
public class OrderValidation implements IOrderValidation {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order validateOrder(String orderId) {
        if (Util.isEmpty(orderId)) {
            throw new RequestException(ExceptionCode.ORDER_ID_NOT_FOUND);
        }
        Order order = repository.findById(orderId).orElse(null);
        if (Util.isEmpty(order)) {
            throw new BusinessException(ExceptionCode.ORDER_NOT_FOUND);
        }
        return order;
    }

    @Override
    public OrderDto validateOrder(OrderDto orderDto) {
        if (Util.isEmpty(orderDto)) {
            throw new RequestException(ExceptionCode.ORDER_NOT_FOUND);
        }
        return orderDto;
    }

    @Override
    public Order validateOrder(Order order) {
        if (Util.isEmpty(order)) {
            throw new RequestException(ExceptionCode.ORDER_NOT_FOUND);
        }
        return order;
    }

}
