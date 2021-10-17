package tr.com.getir.book.productservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.productdomain.entity.Stock;
import tr.com.getir.book.productdomain.repository.ProductRepository;
import tr.com.getir.book.productdomain.repository.StockRepository;
import tr.com.getir.book.productservice.converter.StockConverter;
import tr.com.getir.book.productservice.service.IStockService;
import tr.com.getir.book.productservice.validation.IProductValidation;
import tr.com.getir.book.productservice.validation.IStockValidation;
import tr.com.getir.book.productservice.view.request.AddStockRequest;
import tr.com.getir.book.productservice.view.request.GetStockRequest;
import tr.com.getir.book.productservice.view.request.WarehouseToDeliveryRequest;
import tr.com.getir.book.productservice.view.response.AddStockResponse;
import tr.com.getir.book.productservice.view.response.GetAllStocksResponse;
import tr.com.getir.book.productservice.view.response.GetStockResponse;
import tr.com.getir.book.productservice.view.response.WarehouseToDeliveryResponse;
import tr.com.getir.book.util.Util;

import java.util.List;

@Service
@Slf4j
public class StockService implements IStockService {

    @Autowired
    private StockConverter converter;

    @Autowired
    private StockRepository repository;

    @Autowired
    private IStockValidation validation;

    @Autowired
    private IProductValidation productValidation;

    @Override
    public AddStockResponse addStock(AddStockRequest request) {
        productValidation.validateProduct(request.getProductId());
        Stock stock = repository.findByProductId(request.getProductId()).orElse(null);
        if (Util.isEmpty(stock)) {
            stock = new Stock();
            stock.setInWarehouseCount(request.getNumberOfProduct());
            stock.setProductId(request.getProductId());
            repository.save(stock);
        } else {
            Long currentStockNumber = stock.getInWarehouseCount() != null ? stock.getInWarehouseCount() : 0l;
            stock.setInWarehouseCount(currentStockNumber + request.getNumberOfProduct());
            repository.save(stock);
        }
        return new AddStockResponse(converter.toDto(stock));
    }

    @Override
    public GetStockResponse getStock(GetStockRequest request) {
        Stock stock = repository.findByProductId(request.getProductId()).orElse(null);
        validation.validateStock(stock);
        return new GetStockResponse(converter.toDto(stock));
    }

    @Override
    public GetAllStocksResponse getAllStocks() {
        List<Stock> stocks = repository.findAll();
        if (Util.isEmpty(stocks)) {
            throw new BusinessException(ExceptionCode.STOCK_NOT_FOUND);
        }
        return new GetAllStocksResponse(converter.toDtoList(stocks));
    }

    @Override
    public WarehouseToDeliveryResponse warehouseToDelivery(WarehouseToDeliveryRequest request) {
        productValidation.validateProduct(request.getProductId());
        Stock stock = repository.findByProductId(request.getProductId()).orElse(null);
        if (Util.isEmpty(stock) || Util.isEmpty(stock.getInWarehouseCount())) {
            throw new BusinessException(ExceptionCode.STOCK_NOT_FOUND);
        }
        if ((stock.getInWarehouseCount() - request.getNumberOfProducts()) <= 0l) {
            throw new BusinessException(ExceptionCode.INSUFFICIENT_STOCK);
        }
        stock.setInWarehouseCount(stock.getInWarehouseCount() - request.getNumberOfProducts());
        stock.setOnDeliveryCount(stock.getOnDeliveryCount() + request.getNumberOfProducts());
        repository.save(stock);
        return new WarehouseToDeliveryResponse(converter.toDto(stock));
    }
}
