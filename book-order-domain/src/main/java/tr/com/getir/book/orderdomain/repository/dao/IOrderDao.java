package tr.com.getir.book.orderdomain.repository.dao;


import tr.com.getir.book.orderdomain.entity.Order;

public interface IOrderDao {

    void insert(Order order);

    void update(Order order);

    void delete(Order order);

}
