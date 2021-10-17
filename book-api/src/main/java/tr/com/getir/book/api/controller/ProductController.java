package tr.com.getir.book.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.getir.book.productservice.service.IProductService;
import tr.com.getir.book.productservice.service.IStockService;
import tr.com.getir.book.productservice.view.request.*;
import tr.com.getir.book.productservice.view.response.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/product-api")
@Api(tags = {"Product API"})
@Slf4j
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IStockService stockService;

    @PostMapping(value = "/create-product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Create product", httpMethod = "POST", response = CreateProductResponse.class)
    public ResponseEntity<CreateProductResponse> createProduct(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for create product service")
                    CreateProductRequest request) {
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.OK);
    }

    @PostMapping(value = "/update-product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Update product", httpMethod = "POST", response = UpdateProductResponse.class)
    public ResponseEntity<UpdateProductResponse> updateProduct(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for update product service")
                    UpdateProductRequest request) {
        return new ResponseEntity<>(productService.updateProduct(request), HttpStatus.OK);
    }

    @PostMapping(value = "/delete-product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Delete product", httpMethod = "POST", response = DeleteProductResponse.class)
    public ResponseEntity<DeleteProductResponse> deleteProduct(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for delete product service")
                    DeleteProductRequest request) {
        return new ResponseEntity<>(productService.deleteProduct(request), HttpStatus.OK);
    }

    @PostMapping(value = "/get-product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Get product", httpMethod = "POST", response = GetProductResponse.class)
    public ResponseEntity<GetProductResponse> getProduct(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for get product service")
                    GetProductRequest request) {
        return new ResponseEntity<>(productService.getProduct(request), HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-products")
    @ApiOperation(value = "Get all products", httpMethod = "GET", response = GetAllProductsResponse.class)
    public ResponseEntity<GetAllProductsResponse> getallProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping(value = "/add-stock", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Add stock", httpMethod = "POST", response = AddStockResponse.class)
    public ResponseEntity<AddStockResponse> addStock(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for add stock service")
                    AddStockRequest request) {
        return new ResponseEntity<>(stockService.addStock(request), HttpStatus.OK);
    }

    @PostMapping(value = "/get-stock", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Get stock", httpMethod = "POST", response = AddStockResponse.class)
    public ResponseEntity<GetStockResponse> getStock(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for get stock service")
                    GetStockRequest request) {
        return new ResponseEntity<>(stockService.getStock(request), HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-stocks")
    @ApiOperation(value = "Add stock", httpMethod = "GET", response = GetAllStocksResponse.class)
    public ResponseEntity<GetAllStocksResponse> getAllStocks() {
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.OK);
    }

}
