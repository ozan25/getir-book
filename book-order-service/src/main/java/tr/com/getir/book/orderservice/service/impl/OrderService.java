package tr.com.getir.book.orderservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerservice.validation.IAddressValidation;
import tr.com.getir.book.customerservice.validation.ICustomerValidation;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.orderdomain.entity.Order;
import tr.com.getir.book.orderdomain.entity.OrderDetail;
import tr.com.getir.book.orderdomain.repository.OrderDetailRepository;
import tr.com.getir.book.orderdomain.repository.OrderRepository;
import tr.com.getir.book.orderservice.constant.OrderStatus;
import tr.com.getir.book.orderservice.converter.OrderConverter;
import tr.com.getir.book.orderservice.converter.OrderDetailConverter;
import tr.com.getir.book.orderservice.service.IOrderService;
import tr.com.getir.book.orderservice.validation.IOrderDetailValidation;
import tr.com.getir.book.orderservice.validation.IOrderValidation;
import tr.com.getir.book.orderservice.view.model.OrderDetailDto;
import tr.com.getir.book.orderservice.view.model.OrderView;
import tr.com.getir.book.orderservice.view.request.CancelOrdersRequest;
import tr.com.getir.book.orderservice.view.request.CreateOrdersRequest;
import tr.com.getir.book.orderservice.view.request.GetOrderRequest;
import tr.com.getir.book.orderservice.view.request.GetOrdersOfCustomerRequest;
import tr.com.getir.book.orderservice.view.response.CancelOrderResponse;
import tr.com.getir.book.orderservice.view.response.CreateOrderResponse;
import tr.com.getir.book.orderservice.view.response.GetOrderResponse;
import tr.com.getir.book.orderservice.view.response.GetOrdersOfCustomerResponse;
import tr.com.getir.book.productservice.service.IStockService;
import tr.com.getir.book.productservice.view.request.DeliveryToWarehouseRequest;
import tr.com.getir.book.productservice.view.request.WarehouseToDeliveryRequest;
import tr.com.getir.book.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService implements IOrderService {

    @Autowired
    private OrderConverter converter;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private IOrderValidation validation;

    @Autowired
    private OrderDetailRepository detailRepository;

    @Autowired
    private OrderDetailConverter detailConverter;

    @Autowired
    private IOrderDetailValidation detailValidation;

    @Autowired
    private ICustomerValidation customerValidation;

    @Autowired
    private IAddressValidation addressValidation;

    @Autowired
    private IStockService stockService;

    @Override
    public CreateOrderResponse createOrder(CreateOrdersRequest request) {
        customerValidation.validateCustomer(request.getCustomerId());
        addressValidation.validateAddress(request.getAddressId());
        detailValidation.validatioOrderDetailDtoList(request.getOrderDetails());

        request.getOrderDetails().stream().forEach(orderDetail -> stockService.warehouseToDelivery(
                new WarehouseToDeliveryRequest(orderDetail.getProductId(), orderDetail.getNumberOfProduct())));

        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setAddressId(request.getAddressId());
        order.setStatus(OrderStatus.ON_DELIVERY.name());
        order.setDeliveryStartDate(new Date());
        repository.save(order);

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDto orderDetailDto : request.getOrderDetails()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setProductId(orderDetailDto.getProductId());
            orderDetail.setNumberOfProduct(orderDetailDto.getNumberOfProduct());
            orderDetails.add(orderDetail);
        }
        detailRepository.saveAll(orderDetails);
        return new CreateOrderResponse(converter.toDto(order), detailConverter.toDtoList(orderDetails));
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrdersRequest request) {
        Order order = validation.validateOrder(request.getOrderId());
        if (!OrderStatus.ON_DELIVERY.name().equals(order.getStatus())) {
            throw new BusinessException(ExceptionCode.ORDER_CAN_NOT_BE_CANCELED);
        }
        order.setStatus(OrderStatus.CANCELED.name());
        repository.save(order);
        List<OrderDetail> orderDetails = detailRepository.findByOrderId(order.getId()).orElse(null);
        detailValidation.validatioOrderDetailList(orderDetails);

        orderDetails.stream().forEach(orderDetail -> stockService.deliveryToWarehouse(
                new DeliveryToWarehouseRequest(orderDetail.getProductId(), orderDetail.getNumberOfProduct())));

        return new CancelOrderResponse();
    }

    @Override
    public GetOrderResponse getOrder(GetOrderRequest request) {
        Order order = validation.validateOrder(request.getOrderId());
        List<OrderDetail> orderDetails = detailRepository.findByOrderId(request.getOrderId()).orElse(null);
        detailValidation.validatioOrderDetailList(orderDetails);
        return new GetOrderResponse(converter.toDto(order), detailConverter.toDtoList(orderDetails));
    }

    @Override
    public GetOrdersOfCustomerResponse getOrdersOfCustomer(GetOrdersOfCustomerRequest request) {
        List<Order> orders = repository.findByCustomerId(request.getCustomerId()).orElse(null);
        if (Util.isEmpty(orders)) {
            throw new BusinessException(ExceptionCode.ORDER_NOT_FOUND);
        }
        if (Util.isNotEmpty(request.getOrderId())) {
            orders = orders.stream().filter(o -> request.getOrderId().equals(o.getId())).collect(Collectors.toList());
        }
        if (Util.isNotEmpty(request.getStatus())) {
            orders = orders.stream().filter(o -> request.getStatus().equals(o.getStatus()))
                    .collect(Collectors.toList());
        }
        List<OrderView> orderViews = new ArrayList<>();
        for (Order order : orders) {
            List<OrderDetail> orderDetails = detailRepository.findByOrderId(order.getId()).orElse(null);
            detailValidation.validatioOrderDetailList(orderDetails);
            orderViews.add(new OrderView(converter.toDto(order), detailConverter.toDtoList(orderDetails)));
        }
        return new GetOrdersOfCustomerResponse(orderViews);
    }
}
