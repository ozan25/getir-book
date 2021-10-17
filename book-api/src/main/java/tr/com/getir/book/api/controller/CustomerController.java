package tr.com.getir.book.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.getir.book.customerservice.service.IAddressService;
import tr.com.getir.book.customerservice.service.impl.CustomerService;
import tr.com.getir.book.customerservice.view.request.*;
import tr.com.getir.book.customerservice.view.response.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/customer-api")
@Api(tags = {"Customer API"})
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private IAddressService addressService;

    @PostMapping(value = "/create-customer", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Create customer", httpMethod = "POST", response = CreateCustomerResponse.class)
    public ResponseEntity<CreateCustomerResponse> createCustomer(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for create customer service")
                    CreateCustomerRequest request) {
        CreateCustomerResponse response = customerService.createCustomer(request);
        return new ResponseEntity<CreateCustomerResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/update-customer", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Update customer", httpMethod = "POST", response = UpdateCustomerResponse.class)
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for update customer service")
                    UpdateCustomerRequest request) {
        UpdateCustomerResponse response = customerService.updateCustomer(request);
        return new ResponseEntity<UpdateCustomerResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/delete-customer", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Delete customer", httpMethod = "POST", response = DeleteCustomerResponse.class)
    public ResponseEntity<DeleteCustomerResponse> deleteCustomer(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for delete customer service")
                    DeleteCustomerRequest request) {
        DeleteCustomerResponse response = customerService.deleteCustomer(request);
        return new ResponseEntity<DeleteCustomerResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/get-customer", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Get customer", httpMethod = "POST", response = String.class)
    public ResponseEntity<GetCustomerResponse> getCustomer(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for get customer service")
                    GetCustomerRequest request) {
        GetCustomerResponse response = customerService.getCustomer(request);
        return new ResponseEntity<GetCustomerResponse>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-customers")
    @ApiOperation(value = "Get all customers", httpMethod = "GET", response = GetAllCustomersResponse.class)
    public ResponseEntity<GetAllCustomersResponse> getallCustomers() {
        GetAllCustomersResponse response = customerService.getAllCustomers();
        return new ResponseEntity<GetAllCustomersResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/create-address", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Create address", httpMethod = "POST", response = CreateAddressResponse.class)
    public ResponseEntity<CreateAddressResponse> createAddress(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for create address service")
                    CreateAddressRequest request) {
        CreateAddressResponse response = addressService.createAddress(request);
        return new ResponseEntity<CreateAddressResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/update-address", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Update address", httpMethod = "POST", response = UpdateAddressResponse.class)
    public ResponseEntity<UpdateAddressResponse> updateAddress(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for update address service")
                    UpdateAddressRequest request) {
        UpdateAddressResponse response = addressService.updateAddress(request);
        return new ResponseEntity<UpdateAddressResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/delete-address", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Delete address", httpMethod = "POST", response = DeleteAddressResponse.class)
    public ResponseEntity<DeleteAddressResponse> deleteAddress(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for delete address service")
                    DeleteAddressRequest request) {
        DeleteAddressResponse response = addressService.deleteAddress(request);
        return new ResponseEntity<DeleteAddressResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/get-addresses", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Get addresses", httpMethod = "POST", response = GetAddressesResponse.class)
    public ResponseEntity<GetAddressesResponse> getAddress(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for get addresses service")
                    GetAddressesRequest request) {
        GetAddressesResponse response = addressService.getAddresses(request);
        return new ResponseEntity<GetAddressesResponse>(response, HttpStatus.OK);
    }

}
