package tr.com.getir.book.customerservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerdomain.repository.AddressRepository;
import tr.com.getir.book.customerdomain.repository.CustomerRepository;
import tr.com.getir.book.customerdomain.repository.dao.AddressDao;
import tr.com.getir.book.customerservice.converter.AddressConverter;
import tr.com.getir.book.customerservice.service.IAddressService;
import tr.com.getir.book.customerservice.view.request.CreateAddressRequest;
import tr.com.getir.book.customerservice.view.request.DeleteAddressRequest;
import tr.com.getir.book.customerservice.view.request.GetAddressesRequest;
import tr.com.getir.book.customerservice.view.request.UpdateAddressRequest;
import tr.com.getir.book.customerservice.view.response.CreateAddressResponse;
import tr.com.getir.book.customerservice.view.response.DeleteAddressResponse;
import tr.com.getir.book.customerservice.view.response.GetAddressesResponse;
import tr.com.getir.book.customerservice.view.response.UpdateAddressResponse;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.util.Util;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressService implements IAddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public CreateAddressResponse createAddress(CreateAddressRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (Util.isEmpty(customer)) {
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        Address address = addressConverter.toEntity(request.getAddress());
        address.setCustomerId(customer.getId());
        addressDao.insert(address);
        CreateAddressResponse response = new CreateAddressResponse();
        response.setAddress(addressConverter.toDto(address));
        return response;
    }

    @Override
    public UpdateAddressResponse updateAddress(UpdateAddressRequest request) {
        if (Util.isEmpty(request.getAddress().getId())) {
            throw new RequestException(ExceptionCode.ADDRESS_ID_NOT_FOUND);
        }
        Address originalAddress = addressRepository.findById(request.getAddress().getId()).orElse(null);
        if (Util.isEmpty(originalAddress)) {
            throw new BusinessException(ExceptionCode.ADDRESS_NOT_FOUND);
        }
        Address address = addressConverter.toEntity(request.getAddress());
        addressDao.update(address);
        UpdateAddressResponse response = new UpdateAddressResponse();
        response.setAddress(addressConverter.toDto(address));
        return response;
    }

    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest request) {
        Address originalAddress = addressRepository.findById(request.getAddressId()).orElse(null);
        if (Util.isEmpty(originalAddress)) {
            throw new BusinessException(ExceptionCode.ADDRESS_NOT_FOUND);
        }
        addressDao.delete(originalAddress);
        return new DeleteAddressResponse();
    }

    @Override
    public GetAddressesResponse getAddresses(GetAddressesRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (Util.isEmpty(customer)) {
            throw new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND);
        }
        List<Address> addresses = addressRepository.findByCustomerId(request.getCustomerId()).orElse(null);
        GetAddressesResponse response = new GetAddressesResponse();
        response.setAddresses(addressConverter.toDtoList(addresses));
        return response;
    }
}
