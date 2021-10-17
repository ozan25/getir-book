package tr.com.getir.book.customerdomain.repository.dao;

import tr.com.getir.book.customerdomain.entity.Customer;

public interface CustomerDao {

    public void insert(Customer customer);

    public void update(Customer customer);

    public void delete(Customer customer);
}
