package tr.com.getir.book.customerservice.service;

import tr.com.getir.book.customerservice.view.request.CreateAddressRequest;
import tr.com.getir.book.customerservice.view.request.DeleteAddressRequest;
import tr.com.getir.book.customerservice.view.request.GetAddressesRequest;
import tr.com.getir.book.customerservice.view.request.UpdateAddressRequest;
import tr.com.getir.book.customerservice.view.response.CreateAddressResponse;
import tr.com.getir.book.customerservice.view.response.DeleteAddressResponse;
import tr.com.getir.book.customerservice.view.response.GetAddressesResponse;
import tr.com.getir.book.customerservice.view.response.UpdateAddressResponse;

public interface IAddressService {

    CreateAddressResponse createAddress(CreateAddressRequest request);

    UpdateAddressResponse updateAddress(UpdateAddressRequest request);

    DeleteAddressResponse deleteAddress(DeleteAddressRequest request);

    GetAddressesResponse getAddresses(GetAddressesRequest request);
}
