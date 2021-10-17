package tr.com.getir.book.productservice.service;

import tr.com.getir.book.productservice.view.request.CreateProductRequest;
import tr.com.getir.book.productservice.view.request.DeleteProductRequest;
import tr.com.getir.book.productservice.view.request.GetProductRequest;
import tr.com.getir.book.productservice.view.request.UpdateProductRequest;
import tr.com.getir.book.productservice.view.response.*;

public interface IProductService {

    CreateProductResponse createProduct(CreateProductRequest request);

    UpdateProductResponse updateProduct(UpdateProductRequest request);

    DeleteProductResponse deleteProduct(DeleteProductRequest request);

    GetProductResponse getProduct(GetProductRequest request);

    GetAllProductsResponse getAllProducts();
}
