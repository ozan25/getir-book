package tr.com.getir.book.orderservice.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.orderdomain.entity.OrderDetail;
import tr.com.getir.book.orderdomain.repository.OrderDetailRepository;
import tr.com.getir.book.orderservice.validation.IOrderDetailValidation;
import tr.com.getir.book.orderservice.view.model.OrderDetailDto;
import tr.com.getir.book.util.Util;

import java.util.List;

@Component
public class OrderDetailValidation implements IOrderDetailValidation {

    @Autowired
    private OrderDetailRepository repository;

    @Override
    public OrderDetail validateOrderDetail(String orderDetailId) {
        if (Util.isEmpty(orderDetailId)) {
            throw new RequestException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
        }
        OrderDetail orderDetail = repository.findById(orderDetailId).orElse(null);
        if (Util.isEmpty(orderDetail)) {
            throw new BusinessException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
        }
        return orderDetail;
    }

    @Override
    public OrderDetailDto validateOrderDetail(OrderDetailDto orderDetailDto) {
        if (Util.isEmpty(orderDetailDto)) {
            throw new RequestException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
        }
        return orderDetailDto;
    }

    @Override
    public OrderDetail validateOrderDetail(OrderDetail orderDetail) {
        if (Util.isEmpty(orderDetail)) {
            throw new RequestException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
        }
        return orderDetail;
    }

    @Override
    public List<OrderDetail> validatioOrderDetailList(List<OrderDetail> orderDetails) {
        if (Util.isEmpty(orderDetails)) {
            throw new BusinessException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
        }
        return orderDetails;
    }
    @Override
    public List<OrderDetailDto> validatioOrderDetailDtoList(List<OrderDetailDto> orderDetails) {
        if (Util.isEmpty(orderDetails)) {
            throw new BusinessException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
        }
        return orderDetails;
    }


}
