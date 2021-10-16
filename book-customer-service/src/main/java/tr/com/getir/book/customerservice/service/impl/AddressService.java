package tr.com.getir.book.customerservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.CustomerRepository;
import tr.com.getir.book.customerdomain.repository.dao.AddressDao;
import tr.com.getir.book.customerservice.converter.AddressConverter;
import tr.com.getir.book.customerservice.service.IAddressService;
import tr.com.getir.book.customerservice.view.model.AddressDto;
import tr.com.getir.book.customerservice.view.request.CreateAddressRequest;
import tr.com.getir.book.customerservice.view.request.DeleteAddressRequest;
import tr.com.getir.book.customerservice.view.request.GetAddressesRequest;
import tr.com.getir.book.customerservice.view.request.UpdateAddressRequest;
import tr.com.getir.book.customerservice.view.response.*;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.util.Util;

@Service
@Slf4j
public class AddressService implements IAddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CreateAddressResponse createAddress(CreateAddressRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if(Util.isEmpty(customer)){
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        Address address = addressConverter.toEntity(request.getAddress());
        addressDao.insert(address);
        CreateAddressResponse response = new CreateAddressResponse();
        response.setAddress(addressConverter.toDto(address));
        return response;
    }

    @Override
    public UpdateAddressResponse updateAddress(UpdateAddressRequest request) {
        return null;
    }

    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest request) {
        return null;
    }

    @Override
    public GetAddressesResponse getAddresses(GetAddressesRequest request) {
        return null;
    }
}
