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
import tr.com.getir.book.customerservice.service.IAddressService;
import tr.com.getir.book.customerservice.view.request.CreateAddressRequest;
import tr.com.getir.book.customerservice.view.request.DeleteAddressRequest;
import tr.com.getir.book.customerservice.view.request.GetAddressesRequest;
import tr.com.getir.book.customerservice.view.request.UpdateAddressRequest;
import tr.com.getir.book.customerservice.view.response.CreateAddressResponse;
import tr.com.getir.book.customerservice.view.response.DeleteAddressResponse;
import tr.com.getir.book.customerservice.view.response.GetAddressesResponse;
import tr.com.getir.book.customerservice.view.response.UpdateAddressResponse;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/address-api")
@Api(tags = {"Address API"})
@Slf4j
public class AddressController {

    @Autowired
    private IAddressService addressService;

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
