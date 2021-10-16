package tr.com.getir.book.customerservice.service;

import tr.com.getir.book.customerservice.view.request.CreateCustomerRequest;
import tr.com.getir.book.customerservice.view.response.CreateCustomerResponse;

public interface ICustomerService {

    CreateCustomerResponse createCustomer(CreateCustomerRequest request);
}
