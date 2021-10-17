package tr.com.getir.book.customerservice.validation;

import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerservice.view.model.AddressDto;

public interface IAddressValidation {

    Address validateAddress(final String addressId);

    AddressDto validateAddress(final AddressDto addressDto);

    Address validateAddress(final Address address);

}
