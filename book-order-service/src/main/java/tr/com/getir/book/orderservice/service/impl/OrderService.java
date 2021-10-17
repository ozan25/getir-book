package tr.com.getir.book.orderservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.AddressRepository;
import tr.com.getir.book.customerdomain.repository.CustomerRepository;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.orderdomain.entity.Order;
import tr.com.getir.book.orderdomain.entity.OrderDetail;
import tr.com.getir.book.orderdomain.repository.OrderDetailRepository;
import tr.com.getir.book.orderdomain.repository.OrderRepository;
import tr.com.getir.book.orderdomain.repository.dao.IOrderDao;
import tr.com.getir.book.orderservice.constant.OrderStatus;
import tr.com.getir.book.orderservice.converter.OrderConverter;
import tr.com.getir.book.orderservice.converter.OrderDetailConverter;
import tr.com.getir.book.orderservice.service.IOrderService;
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
import tr.com.getir.book.productdomain.entity.Product;
import tr.com.getir.book.productdomain.entity.Stock;
import tr.com.getir.book.productdomain.repository.ProductRepository;
import tr.com.getir.book.productdomain.repository.StockRepository;
import tr.com.getir.book.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService implements IOrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailConverter orderDetailConverter;

    @Override
    public CreateOrderResponse createOrder(CreateOrdersRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (Util.isEmpty(customer)) {
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        Address address = addressRepository.findById(request.getAddressId()).orElse(null);
        if (Util.isEmpty(address)) {
            throw new BusinessException(ExceptionCode.ADDRESS_NOT_FOUND);
        }
        for (OrderDetailDto orderDetail : request.getOrderDetails()) {
            Product product = productRepository.findById(orderDetail.getProductId()).orElse(null);
            if (Util.isEmpty(product)) {
                throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
            }
            Stock stock = stockRepository.findByProductId(orderDetail.getProductId()).orElse(null);
            if (Util.isEmpty(stock.getInWarehouseCount()) ||
                    stock.getInWarehouseCount() < orderDetail.getNumberOfProduct()) {
                throw new BusinessException(ExceptionCode.INSUFFICIENT_STOCK);
            }
        }

        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setAddressId(request.getAddressId());
        order.setStatus(OrderStatus.ON_DELIVERY.name());
        order.setDeliveryStartDate(new Date());
        orderDao.insert(order);

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDto orderDetailDto : request.getOrderDetails()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setProductId(orderDetailDto.getProductId());
            orderDetail.setNumberOfProduct(orderDetailDto.getNumberOfProduct());
            orderDetails.add(orderDetail);
        }
        orderDetailRepository.saveAll(orderDetails);
        CreateOrderResponse response = new CreateOrderResponse();
        response.setOrder(orderConverter.toDto(order));
        response.setOrderDetails(orderDetailConverter.toDtoList(orderDetails));
        return response;
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrdersRequest request) {
        Order order = orderRepository.findById(request.getOrderId()).orElse(null);
        if (Util.isEmpty(order)) {
            throw new BusinessException(ExceptionCode.ORDER_NOT_FOUND);
        }
        if (!OrderStatus.ON_DELIVERY.name().equals(order.getStatus())) {
            throw new BusinessException(ExceptionCode.ORDER_CAN_NOT_BE_CANCELED);
        }
        order.setStatus(OrderStatus.CANCELED.name());
        orderRepository.save(order);
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(order.getId()).orElse(null);
        if (Util.isEmpty(orderDetails)) {
            throw new BusinessException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
        }
        for (OrderDetail orderDetail : orderDetails) {
            Stock stock = stockRepository.findByProductId(orderDetail.getProductId()).orElse(null);
            stock.setOnDeliveryCount(stock.getOnDeliveryCount() - orderDetail.getNumberOfProduct());
            stock.setInWarehouseCount(stock.getInWarehouseCount() + orderDetail.getNumberOfProduct());
            stockRepository.save(stock);
        }
        return new CancelOrderResponse();
    }

    @Override
    public GetOrderResponse getOrder(GetOrderRequest request) {
        Order order = orderRepository.findById(request.getOrderId()).orElse(null);
        if (Util.isEmpty(order)) {
            throw new BusinessException(ExceptionCode.ORDER_NOT_FOUND);
        }
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(request.getOrderId()).orElse(null);
        if (Util.isEmpty(orderDetails)) {
            throw new BusinessException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
        }
        GetOrderResponse response = new GetOrderResponse();
        response.setOrder(orderConverter.toDto(order));
        response.setOrderDetails(orderDetailConverter.toDtoList(orderDetails));
        return response;
    }

    @Override
    public GetOrdersOfCustomerResponse getOrdersOfCustomer(GetOrdersOfCustomerRequest request) {
        List<Order> orders = orderRepository.findByCustomerId(request.getCustomerId()).orElse(null);
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
            OrderView orderView = new OrderView();
            orderView.setOrder(orderConverter.toDto(order));
            List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(order.getId()).orElse(null);
            if (Util.isEmpty(orderDetails)) {
                throw new BusinessException(ExceptionCode.ORDER_DETAILS_NOT_FOUND);
            }
            orderView.setOrderDetails(orderDetailConverter.toDtoList(orderDetails));
            orderViews.add(orderView);
        }
        return new GetOrdersOfCustomerResponse(orderViews);
    }
}
