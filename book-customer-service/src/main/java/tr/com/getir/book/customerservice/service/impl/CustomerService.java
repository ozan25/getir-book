package tr.com.getir.book.customerservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.AddressRepository;
import tr.com.getir.book.customerdomain.repository.CustomerRepository;
import tr.com.getir.book.customerservice.converter.CustomerConverter;
import tr.com.getir.book.customerservice.service.IAddressService;
import tr.com.getir.book.customerservice.service.ICustomerService;
import tr.com.getir.book.customerservice.validation.ICustomerValidation;
import tr.com.getir.book.customerservice.view.request.*;
import tr.com.getir.book.customerservice.view.response.*;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.util.Util;

import java.util.List;

@Service
@Slf4j
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerConverter converter;

    @Autowired
    private ICustomerValidation validation;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private IAddressService addressService;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        validation.validateCustomer(request.getCustomer());
        Customer customer = converter.toEntity(request.getCustomer());
        repository.save(customer);
        if (Util.isNotEmpty(request.getAddresses())) {
            request.getAddresses().stream()
                    .forEach(addressDto -> addressService.createAddress(
                            new CreateAddressRequest(customer.getId(), addressDto)));
        }
        return new CreateCustomerResponse(converter.toDto(customer));
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) {
        validation.validateCustomer(request.getCustomer().getId());
        Customer customer = converter.toEntity(request.getCustomer());
        repository.save(customer);
        return new UpdateCustomerResponse(converter.toDto(customer));
    }

    @Override
    public DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest request) {
        Customer customer = validation.validateCustomer(request.getCustomerId());
        List<Address> addresses = addressRepository.findByCustomerId(request.getCustomerId()).orElse(null);
        if (Util.isNotEmpty(addresses)) {
            addresses.stream()
                    .forEach(address -> addressService.deleteAddress(
                            new DeleteAddressRequest(address.getId())));
        }
        repository.delete(customer);
        return new DeleteCustomerResponse();
    }

    @Override
    public GetCustomerResponse getCustomer(GetCustomerRequest request) {
        Customer customer = validation.validateCustomer(request.getCustomerId());
        return new GetCustomerResponse(converter.toDto(customer));
    }

    @Override
    public GetAllCustomersResponse getAllCustomers() {
        List<Customer> customers = repository.findAll();
        if (Util.isEmpty(customers)) {
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        return new GetAllCustomersResponse(converter.toDtoList(customers));
    }

}
