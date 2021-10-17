package tr.com.getir.book.productservice.validation;


import tr.com.getir.book.productdomain.entity.Stock;

public interface IStockValidation {

    Stock validateStock(final Stock stock);

}
