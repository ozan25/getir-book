package tr.com.getir.book.orderservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
import tr.com.getir.book.orderservice.validation.impl.OrderValidation;
import tr.com.getir.book.orderservice.view.model.OrderDetailDto;
import tr.com.getir.book.orderservice.view.model.OrderView;
import tr.com.getir.book.orderservice.view.request.*;
import tr.com.getir.book.orderservice.view.response.*;
import tr.com.getir.book.productservice.service.IStockService;
import tr.com.getir.book.productservice.view.request.DeliveryToWarehouseRequest;
import tr.com.getir.book.productservice.view.request.UpdateDeliveryStockRequest;
import tr.com.getir.book.productservice.view.request.WarehouseToDeliveryRequest;
import tr.com.getir.book.util.DateUtil;
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
    private OrderValidation validation;

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
    @Transactional
    public CreateOrderResponse createOrder(CreateOrdersRequest request) {
        customerValidation.validateCustomer(request.getCustomerId());
        addressValidation.validateAddress(request.getAddressId());
        detailValidation.validatioOrderDetailDtoList(request.getOrderDetails());
        updateStocksFromWarehouseToDelivery(request.getOrderDetails());
        Order order = saveOrder(request.getCustomerId(), request.getAddressId());
        List<OrderDetail> orderDetails = saveOrderDetails(request.getOrderDetails(), order.getId());
        return new CreateOrderResponse(converter.toDto(order), detailConverter.toDtoList(orderDetails));
    }

    @Override
    @Transactional
    public CancelOrderResponse cancelOrder(CancelOrdersRequest request) {
        Order order = validation.validateOrder(request.getOrderId());
        if (!OrderStatus.ON_DELIVERY.name().equals(order.getStatus())) {
            throw new BusinessException(ExceptionCode.ORDER_CAN_NOT_BE_CANCELED);
        }
        order.setStatus(OrderStatus.CANCELED.name());
        repository.save(order);
        List<OrderDetail> orderDetails = detailRepository.findByOrderId(order.getId()).orElse(null);
        orderDetails = detailValidation.validatioOrderDetailList(orderDetails);
        updateStocksFromDeliveryToWarehouse(orderDetails);
        return new CancelOrderResponse();
    }

    @Override
    public CompleteOrderResponse completeOrder(CompleteOrdersRequest request) {
        Order order = validation.validateOrder(request.getOrderId());
        if (!OrderStatus.ON_DELIVERY.name().equals(order.getStatus())) {
            throw new BusinessException(ExceptionCode.ORDER_CAN_NOT_BE_COMPLETED);
        }
        order.setStatus(OrderStatus.COMPLETED.name());
        repository.save(order);
        List<OrderDetail> orderDetails = detailRepository.findByOrderId(order.getId()).orElse(null);
        orderDetails = detailValidation.validatioOrderDetailList(orderDetails);
        removeDeliveredStocks(orderDetails);
        return new CompleteOrderResponse(converter.toDto(order), detailConverter.toDtoList(orderDetails));
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
        orders = filterByOrderId(request.getOrderId(), orders);
        orders = filterByStatus(request.getStatus(), orders);
        return new GetOrdersOfCustomerResponse(createOrderViews(orders));
    }

    private List<OrderView> createOrderViews(List<Order> orders) {
        List<OrderView> orderViews = new ArrayList<>();
        for (Order order : orders) {
            List<OrderDetail> orderDetails = detailRepository.findByOrderId(order.getId()).orElse(null);
            detailValidation.validatioOrderDetailList(orderDetails);
            orderViews.add(new OrderView(converter.toDto(order), detailConverter.toDtoList(orderDetails)));
        }
        return orderViews;
    }

    private List<Order> filterByStatus(String status, List<Order> orders) {
        if (Util.isNotEmpty(status)) {
            orders = orders.stream().filter(o -> status.equals(o.getStatus())).collect(Collectors.toList());
        }
        return orders;
    }

    private List<Order> filterByOrderId(String orderId, List<Order> orders) {
        if (Util.isNotEmpty(orderId)) {
            orders = orders.stream().filter(o -> orderId.equals(o.getId())).collect(Collectors.toList());
        }
        return orders;
    }

    private List<OrderDetail> saveOrderDetails(List<OrderDetailDto> orderDetailDtos, String orderId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDto orderDetailDto : orderDetailDtos) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setProductId(orderDetailDto.getProductId());
            orderDetail.setNumberOfProduct(orderDetailDto.getNumberOfProduct());
            orderDetail.setTotalPrice(orderDetailDto.getTotalPrice());
            orderDetails.add(orderDetail);
        }
        detailRepository.saveAll(orderDetails);
        return orderDetails;
    }

    private Order saveOrder(String customerId, String addressId) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setAddressId(addressId);
        order.setStatus(OrderStatus.ON_DELIVERY.name());
        order.setDeliveryStartDate(new Date());
        repository.save(order);
        return order;
    }

    private void updateStocksFromWarehouseToDelivery(List<OrderDetailDto> orderDetails) {
        orderDetails.forEach(orderDetail -> stockService.warehouseToDelivery(
                new WarehouseToDeliveryRequest(orderDetail.getProductId(), orderDetail.getNumberOfProduct())));
    }

    private void updateStocksFromDeliveryToWarehouse(List<OrderDetail> orderDetails) {
        orderDetails.forEach(orderDetail -> stockService.deliveryToWarehouse(
                new DeliveryToWarehouseRequest(orderDetail.getProductId(), orderDetail.getNumberOfProduct())));
    }

    private void removeDeliveredStocks(List<OrderDetail> orderDetails) {
        orderDetails.forEach(orderDetail -> stockService.updateDeliveryStock(
                new UpdateDeliveryStockRequest(orderDetail.getProductId(), orderDetail.getNumberOfProduct())));
    }
}
