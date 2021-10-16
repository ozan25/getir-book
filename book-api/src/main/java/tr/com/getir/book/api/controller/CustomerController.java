package tr.com.getir.book.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer-api")
@Api(tags = {"Customer services"})
@Slf4j
public class CustomerController {

    @GetMapping(value = "/get-customers")
    @ApiOperation(value = "get customers", httpMethod = "GET", response = String.class)
    public ResponseEntity<String> getCustomer() {
        return new ResponseEntity<>("ozan", HttpStatus.OK);
    }

}
