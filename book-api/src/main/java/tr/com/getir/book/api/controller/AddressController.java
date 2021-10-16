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
import tr.com.getir.book.customerservice.view.response.CreateAddressResponse;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/address-api")
@Api(tags = {"Address services"})
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

}
