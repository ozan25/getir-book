package tr.com.getir.book.orderservice.service;

import tr.com.getir.book.orderservice.view.request.*;
import tr.com.getir.book.orderservice.view.response.*;

public interface IOrderService {

    CreateOrderResponse createOrder(CreateOrdersRequest request);

    CancelOrderResponse cancelOrder(CancelOrdersRequest request);

    CompleteOrderResponse completeOrder(CompleteOrdersRequest request);

    GetOrderResponse getOrder(GetOrderRequest request);

    GetOrdersOfCustomerResponse getOrdersOfCustomer(GetOrdersOfCustomerRequest request);
}
