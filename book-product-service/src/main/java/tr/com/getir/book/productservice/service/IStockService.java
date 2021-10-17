package tr.com.getir.book.productservice.service;

import tr.com.getir.book.productservice.view.request.*;
import tr.com.getir.book.productservice.view.response.*;

public interface IStockService {

    AddStockResponse addStock(AddStockRequest request);

    GetStockResponse getStock(GetStockRequest request);

    GetAllStocksResponse getAllStocks();

    WarehouseToDeliveryResponse warehouseToDelivery(WarehouseToDeliveryRequest request);

    DeliveryToWarehouseResponse deliveryToWarehouse(DeliveryToWarehouseRequest request);

    UpdateDeliveryStockResponse updateDeliveryStock(UpdateDeliveryStockRequest request);

}
