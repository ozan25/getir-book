package tr.com.getir.book.customerservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.repository.AddressRepository;
import tr.com.getir.book.customerservice.converter.AddressConverter;
import tr.com.getir.book.customerservice.service.IAddressService;
import tr.com.getir.book.customerservice.validation.IAddressValidation;
import tr.com.getir.book.customerservice.validation.ICustomerValidation;
import tr.com.getir.book.customerservice.view.request.CreateAddressRequest;
import tr.com.getir.book.customerservice.view.request.DeleteAddressRequest;
import tr.com.getir.book.customerservice.view.request.GetAddressesRequest;
import tr.com.getir.book.customerservice.view.request.UpdateAddressRequest;
import tr.com.getir.book.customerservice.view.response.CreateAddressResponse;
import tr.com.getir.book.customerservice.view.response.DeleteAddressResponse;
import tr.com.getir.book.customerservice.view.response.GetAddressesResponse;
import tr.com.getir.book.customerservice.view.response.UpdateAddressResponse;

import java.util.List;

@Service
@Slf4j
public class AddressService implements IAddressService {

    @Autowired
    private AddressConverter converter;

    @Autowired
    private AddressRepository repository;

    @Autowired
    private IAddressValidation validation;

    @Autowired
    private ICustomerValidation customerValidation;

    @Override
    public CreateAddressResponse createAddress(CreateAddressRequest request) {
        customerValidation.validateCustomer(request.getCustomerId());
        Address address = converter.toEntity(request.getAddress());
        address.setCustomerId(request.getCustomerId());
        repository.save(address);
        return new CreateAddressResponse(converter.toDto(address));
    }

    @Override
    public UpdateAddressResponse updateAddress(UpdateAddressRequest request) {
        validation.validateAddress(request.getAddress().getId());
        Address address = converter.toEntity(request.getAddress());
        repository.save(address);
        return new UpdateAddressResponse(converter.toDto(address));
    }

    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest request) {
        Address address = validation.validateAddress(request.getAddressId());
        repository.delete(address);
        return new DeleteAddressResponse();
    }

    @Override
    public GetAddressesResponse getAddresses(GetAddressesRequest request) {
        customerValidation.validateCustomer(request.getCustomerId());
        List<Address> addresses = repository.findByCustomerId(request.getCustomerId()).orElse(null);
        return new GetAddressesResponse(converter.toDtoList(addresses));
    }
}
