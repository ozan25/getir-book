package tr.com.getir.book.productdomain.repository.dao;

import tr.com.getir.book.productdomain.entity.Stock;

public interface IStockDao {

    void insert(Stock stock);

    void update(Stock stock);

    void delete(Stock stock);

}
