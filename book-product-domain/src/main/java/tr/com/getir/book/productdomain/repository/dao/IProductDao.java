package tr.com.getir.book.productdomain.repository.dao;

import tr.com.getir.book.productdomain.entity.Product;

public interface IProductDao {

    void insert(Product product);

    void update(Product product);

    void delete(Product product);

}
