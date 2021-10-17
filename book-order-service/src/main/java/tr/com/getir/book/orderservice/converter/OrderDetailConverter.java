package tr.com.getir.book.orderservice.converter;

import org.springframework.stereotype.Component;
import tr.com.getir.book.commonservice.converter.BaseConverter;
import tr.com.getir.book.orderdomain.entity.OrderDetail;
import tr.com.getir.book.orderservice.view.model.OrderDetailDto;

@Component
public class OrderDetailConverter extends BaseConverter<OrderDetailDto, OrderDetail> {
    @Override
    protected Class<OrderDetailDto> getDtoClass() {
        return OrderDetailDto.class;
    }

    @Override
    protected Class<OrderDetail> getEntityClass() {
        return OrderDetail.class;
    }
}
