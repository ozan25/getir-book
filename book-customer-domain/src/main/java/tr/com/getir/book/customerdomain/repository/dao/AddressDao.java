package tr.com.getir.book.customerdomain.repository.dao;

import tr.com.getir.book.customerdomain.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDao {

    void insert(Address address);

    void update(Address address);

    void delete(Address address);

}
