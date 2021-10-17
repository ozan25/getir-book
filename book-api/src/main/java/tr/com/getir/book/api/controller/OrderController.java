package tr.com.getir.book.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.getir.book.orderservice.service.IOrderService;
import tr.com.getir.book.orderservice.view.request.CancelOrdersRequest;
import tr.com.getir.book.orderservice.view.request.CreateOrdersRequest;
import tr.com.getir.book.orderservice.view.request.GetOrderRequest;
import tr.com.getir.book.orderservice.view.request.GetOrdersOfCustomerRequest;
import tr.com.getir.book.orderservice.view.response.CancelOrderResponse;
import tr.com.getir.book.orderservice.view.response.CreateOrderResponse;
import tr.com.getir.book.orderservice.view.response.GetOrderResponse;
import tr.com.getir.book.orderservice.view.response.GetOrdersOfCustomerResponse;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/order-api")
@Api(tags = {"Order API"})
@Slf4j
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @PostMapping(value = "/create-order", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Create order", httpMethod = "POST", response = CreateOrderResponse.class)
    public ResponseEntity<CreateOrderResponse> createOrder(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for create order service")
                    CreateOrdersRequest request) {
        return new ResponseEntity<>(orderService.createOrder(request), HttpStatus.OK);
    }

    @PostMapping(value = "/cancel-order", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Cancel order", httpMethod = "POST", response = CancelOrderResponse.class)
    public ResponseEntity<CancelOrderResponse> cancelOrder(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for cancel order service")
                    CancelOrdersRequest request) {
        return new ResponseEntity<>(orderService.cancelOrder(request), HttpStatus.OK);
    }

    @PostMapping(value = "/get-order", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Delete order", httpMethod = "POST", response = GetOrderResponse.class)
    public ResponseEntity<GetOrderResponse> getOrder(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for get order service")
                    GetOrderRequest request) {
        return new ResponseEntity<>(orderService.getOrder(request), HttpStatus.OK);
    }

    @PostMapping(value = "/get-orders-of-customer", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Get orders of customer", httpMethod = "POST", response = GetOrdersOfCustomerResponse.class)
    public ResponseEntity<GetOrdersOfCustomerResponse> getOrdersOfCustomer(
            @Valid @RequestBody
            @ApiParam(required = true, value = "Wrapped input fields for get orders of customer service")
                    GetOrdersOfCustomerRequest request) {
        return new ResponseEntity<>(orderService.getOrdersOfCustomer(request), HttpStatus.OK);
    }


}
