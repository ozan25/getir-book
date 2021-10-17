package tr.com.getir.book.orderdomain.repository.dao;


import tr.com.getir.book.orderdomain.entity.OrderDetail;

public interface IOrderDetailDao {

    void insert(OrderDetail orderDetail);

    void update(OrderDetail orderDetail);

    void delete(OrderDetail orderDetail);

}
