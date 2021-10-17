package tr.com.getir.book.customerservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.AddressRepository;
import tr.com.getir.book.customerdomain.repository.CustomerRepository;
import tr.com.getir.book.customerdomain.repository.dao.AddressDao;
import tr.com.getir.book.customerdomain.repository.dao.CustomerDao;
import tr.com.getir.book.customerservice.converter.CustomerConverter;
import tr.com.getir.book.customerservice.service.IAddressService;
import tr.com.getir.book.customerservice.service.ICustomerService;
import tr.com.getir.book.customerservice.view.model.AddressDto;
import tr.com.getir.book.customerservice.view.request.*;
import tr.com.getir.book.customerservice.view.response.*;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.util.Util;

import java.util.List;

@Service
@Slf4j
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private IAddressService addressService;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = customerConverter.toEntity(request.getCustomer());
        customerDao.insert(customer);
        if (Util.isNotEmpty(request.getAddresses())) {
            for (AddressDto addressDto : request.getAddresses()) {
                addressService.createAddress(new CreateAddressRequest(customer.getId(), addressDto));
            }
        }
        CreateCustomerResponse response = new CreateCustomerResponse();
        response.setCustomer(customerConverter.toDto(customer));
        return response;
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) {
        if (Util.isEmpty(request.getCustomer().getId())) {
            throw new RequestException(ExceptionCode.CUSTOMER_ID_NOT_FOUND);
        }
        Customer originalCustomer = customerRepository.findById(request.getCustomer().getId()).orElse(null);
        if (Util.isEmpty(originalCustomer)) {
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        Customer customer = customerConverter.toEntity(request.getCustomer());
        customerDao.update(customer);
        UpdateCustomerResponse response = new UpdateCustomerResponse();
        response.setCustomer(customerConverter.toDto(customer));
        return response;
    }

    @Override
    public DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (Util.isEmpty(customer)) {
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        List<Address> addresses = addressRepository.findByCustomerId(customer.getId()).orElse(null);
        if (Util.isNotEmpty(addresses)) {
            for (Address address : addresses) {
                addressService.deleteAddress(new DeleteAddressRequest(address.getId()));
            }
        }
        customerDao.delete(customer);
        return new DeleteCustomerResponse();
    }

    @Override
    public GetCustomerResponse getCustomer(GetCustomerRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (Util.isEmpty(customer)) {
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomerDto(customerConverter.toDto(customer));
        return response;
    }

    @Override
    public GetAllCustomersResponse getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if(Util.isEmpty(customers)){
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        GetAllCustomersResponse response = new GetAllCustomersResponse();
        response.setCustomers(customerConverter.toDtoList(customers));
        return response;
    }

}
