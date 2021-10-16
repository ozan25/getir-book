package tr.com.getir.book.customerservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.CustomerRepository;
import tr.com.getir.book.customerdomain.repository.dao.AddressDao;
import tr.com.getir.book.customerdomain.repository.dao.CustomerDao;
import tr.com.getir.book.customerservice.service.ICustomerService;
import tr.com.getir.book.customerservice.view.request.CreateCustomerRequest;
import tr.com.getir.book.customerservice.view.response.CreateCustomerResponse;

@Service
@Slf4j
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {

        Customer customer = new Customer();
        customer.setName(request.getCustomer().getName());
        customer.setSurName(request.getCustomer().getSurName());
        customerDao.insertData(customer);

        Address address = new Address();
        address.setName("ev");
        address.setCustomer(customer);

        addressDao.insert(address);

        CreateCustomerResponse response = new CreateCustomerResponse();
        response.setCustomer(null);
        return response;
    }

}
