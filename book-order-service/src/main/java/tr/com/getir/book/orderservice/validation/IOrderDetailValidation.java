package tr.com.getir.book.orderservice.validation;

import org.springframework.stereotype.Service;
import tr.com.getir.book.orderdomain.entity.OrderDetail;
import tr.com.getir.book.orderservice.view.model.OrderDetailDto;

import java.util.List;

public interface IOrderDetailValidation {

    OrderDetail validateOrderDetail(final String orderDetailId);

    OrderDetailDto validateOrderDetail(final OrderDetailDto orderDetailDto);

    OrderDetail validateOrderDetail(final OrderDetail orderDetail);

    List<OrderDetail> validatioOrderDetailList(final List<OrderDetail> orderDetails);

    List<OrderDetailDto> validatioOrderDetailDtoList(final List<OrderDetailDto> orderDetails);
}
