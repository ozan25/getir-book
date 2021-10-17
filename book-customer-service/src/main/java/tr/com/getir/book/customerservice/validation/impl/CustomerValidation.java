package tr.com.getir.book.customerservice.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.CustomerRepository;
import tr.com.getir.book.customerservice.validation.ICustomerValidation;
import tr.com.getir.book.customerservice.view.model.CustomerDto;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.util.Util;

@Component
public class CustomerValidation implements ICustomerValidation {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer validateCustomer(String customerId) {
        if (Util.isEmpty(customerId)) {
            throw new RequestException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        Customer customer = repository.findById(customerId).orElse(null);
        if (Util.isEmpty(customer)) {
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        return customer;
    }

    @Override
    public CustomerDto validateCustomer(CustomerDto customerDto) {
        if (Util.isEmpty(customerDto)) {
            throw new RequestException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        return customerDto;
    }

    @Override
    public Customer validateCustomer(Customer customer) {
        if (Util.isEmpty(customer)) {
            throw new RequestException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        return customer;
    }
}
