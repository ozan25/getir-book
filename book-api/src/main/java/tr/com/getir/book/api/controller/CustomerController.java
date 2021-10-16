package tr.com.getir.book.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.getir.book.customerservice.model.request.CreateCustomerRequest;
import tr.com.getir.book.customerservice.model.response.CreateCustomerResponse;
import tr.com.getir.book.customerservice.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/customer-api")
@Api(tags = {"Customer services"})
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/get-customers")
    @ApiOperation(value = "Get customers", httpMethod = "GET", response = String.class)
    public ResponseEntity<String> getCustomer() {
        return new ResponseEntity<>("ozan", HttpStatus.OK);
    }

    @PostMapping(value = "/create-customers", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Create customers", httpMethod = "POST", response = String.class)
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for create customer service") CreateCustomerRequest request) {
        CreateCustomerResponse response = customerService.createCustomer(request);
        return new ResponseEntity<CreateCustomerResponse>(response, HttpStatus.OK);
    }

}
