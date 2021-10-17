package tr.com.getir.book.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.getir.book.productservice.service.impl.ProductService;
import tr.com.getir.book.productservice.view.request.CreateProductRequest;
import tr.com.getir.book.productservice.view.request.DeleteProductRequest;
import tr.com.getir.book.productservice.view.request.GetProductRequest;
import tr.com.getir.book.productservice.view.request.UpdateProductRequest;
import tr.com.getir.book.productservice.view.response.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/product-api")
@Api(tags = {"Product API"})
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create-product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Create product", httpMethod = "POST", response = CreateProductResponse.class)
    public ResponseEntity<CreateProductResponse> createProduct(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for create product service")
                    CreateProductRequest request) {
        CreateProductResponse response = productService.createProduct(request);
        return new ResponseEntity<CreateProductResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/update-product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Update product", httpMethod = "POST", response = UpdateProductResponse.class)
    public ResponseEntity<UpdateProductResponse> updateProduct(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for update product service")
                    UpdateProductRequest request) {
        UpdateProductResponse response = productService.updateProduct(request);
        return new ResponseEntity<UpdateProductResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/delete-product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Delete product", httpMethod = "POST", response = DeleteProductResponse.class)
    public ResponseEntity<DeleteProductResponse> deleteProduct(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for delete product service")
                    DeleteProductRequest request) {
        DeleteProductResponse response = productService.deleteProduct(request);
        return new ResponseEntity<DeleteProductResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/get-product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Get product", httpMethod = "POST", response = String.class)
    public ResponseEntity<GetProductResponse> getProduct(
            @Valid @RequestBody @ApiParam(required = true, value = "Wrapped input fields for get product service")
                    GetProductRequest request) {
        GetProductResponse response = productService.getProduct(request);
        return new ResponseEntity<GetProductResponse>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-products")
    @ApiOperation(value = "Get all products", httpMethod = "GET", response = GetAllProductsResponse.class)
    public ResponseEntity<GetAllProductsResponse> getallProducts() {
        GetAllProductsResponse response = productService.getAllProducts();
        return new ResponseEntity<GetAllProductsResponse>(response, HttpStatus.OK);
    }

}
