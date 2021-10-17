package tr.com.getir.book.orderservice.service;

import tr.com.getir.book.orderservice.view.request.CancelOrdersRequest;
import tr.com.getir.book.orderservice.view.request.CreateOrdersRequest;
import tr.com.getir.book.orderservice.view.request.GetOrderRequest;
import tr.com.getir.book.orderservice.view.request.GetOrdersOfCustomerRequest;
import tr.com.getir.book.orderservice.view.response.CancelOrderResponse;
import tr.com.getir.book.orderservice.view.response.CreateOrderResponse;
import tr.com.getir.book.orderservice.view.response.GetOrderResponse;
import tr.com.getir.book.orderservice.view.response.GetOrdersOfCustomerResponse;

public interface IOrderService {

    CreateOrderResponse createOrder(CreateOrdersRequest request);

    CancelOrderResponse cancelOrder(CancelOrdersRequest request);

    GetOrderResponse getOrder(GetOrderRequest request);

    GetOrdersOfCustomerResponse getOrdersOfCustomer(GetOrdersOfCustomerRequest request);
}
