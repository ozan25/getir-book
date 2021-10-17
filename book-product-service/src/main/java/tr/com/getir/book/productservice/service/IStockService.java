package tr.com.getir.book.productservice.service;

import tr.com.getir.book.productservice.view.request.AddStockRequest;
import tr.com.getir.book.productservice.view.request.GetStockRequest;
import tr.com.getir.book.productservice.view.request.WarehouseToDeliveryRequest;
import tr.com.getir.book.productservice.view.response.AddStockResponse;
import tr.com.getir.book.productservice.view.response.GetAllStocksResponse;
import tr.com.getir.book.productservice.view.response.GetStockResponse;
import tr.com.getir.book.productservice.view.response.WarehouseToDeliveryResponse;

public interface IStockService {

    AddStockResponse addStock(AddStockRequest request);

    GetStockResponse getStock(GetStockRequest request);

    GetAllStocksResponse getAllStocks();

    WarehouseToDeliveryResponse warehouseToDelivery(WarehouseToDeliveryRequest request);

}
