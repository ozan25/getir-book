package tr.com.getir.book.orderservice.converter;

import org.springframework.stereotype.Component;
import tr.com.getir.book.commonservice.converter.BaseConverter;
import tr.com.getir.book.orderdomain.entity.Order;
import tr.com.getir.book.orderservice.view.model.OrderDto;

@Component
public class OrderConverter extends BaseConverter<OrderDto, Order> {
    @Override
    protected Class<OrderDto> getDtoClass() {
        return OrderDto.class;
    }

    @Override
    protected Class<Order> getEntityClass() {
        return Order.class;
    }
}
