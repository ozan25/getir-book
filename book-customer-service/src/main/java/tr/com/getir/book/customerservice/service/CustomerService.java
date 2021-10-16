package tr.com.getir.book.customerservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.CustomerRepository;
import tr.com.getir.book.customerdomain.repository.dao.CustomerDao;
import tr.com.getir.book.customerservice.model.request.CreateCustomerRequest;
import tr.com.getir.book.customerservice.model.response.CreateCustomerResponse;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDao customerDao;

    public String getCustomer() {
        return "ozan emrah";
    }

    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurName(request.getSurName());
        customerDao.insertData(customer);
        CreateCustomerResponse response = new CreateCustomerResponse();
        response.setId(123456l);
        return response;
    }

}
