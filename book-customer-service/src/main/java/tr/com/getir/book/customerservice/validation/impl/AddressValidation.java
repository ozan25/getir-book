package tr.com.getir.book.customerservice.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerdomain.repository.AddressRepository;
import tr.com.getir.book.customerservice.validation.IAddressValidation;
import tr.com.getir.book.customerservice.view.model.AddressDto;
import tr.com.getir.book.exception.BusinessException;
import tr.com.getir.book.exception.RequestException;
import tr.com.getir.book.exception.constant.ExceptionCode;
import tr.com.getir.book.util.Util;

@Component
public class AddressValidation implements IAddressValidation {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address validateAddress(String addressId) {
        if (Util.isEmpty(addressId)) {
            throw new RequestException(ExceptionCode.ADDRESS_ID_NOT_FOUND);
        }
        Address address = addressRepository.findById(addressId).orElse(null);
        if (Util.isEmpty(address)) {
            throw new BusinessException(ExceptionCode.ADDRESS_NOT_FOUND);
        }
        return address;
    }

    @Override
    public AddressDto validateAddress(AddressDto addressDto) {
        if (Util.isEmpty(addressDto)) {
            throw new RequestException(ExceptionCode.ADDRESS_NOT_FOUND);
        }
        return addressDto;
    }

    @Override
    public Address validateAddress(Address address) {
        if (Util.isEmpty(address)) {
            throw new RequestException(ExceptionCode.ADDRESS_NOT_FOUND);
        }
        return address;
    }
}