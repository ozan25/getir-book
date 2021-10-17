package tr.com.getir.book.orderservice.validation.impl;

import org.springframework.stereotype.Component;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.orderdomain.entity.OrderDetail;
import tr.com.getir.book.orderservice.validation.IOrderDetailValidation;
import tr.com.getir.book.orderservice.view.model.OrderDetailDto;
import tr.com.getir.book.util.Util;

import java.util.List;

@Component
public class OrderDetailValidation implements IOrderDetailValidation {

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
