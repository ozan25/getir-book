package tr.com.getir.book.customerservice.service;

import tr.com.getir.book.customerservice.view.request.CreateCustomerRequest;
import tr.com.getir.book.customerservice.view.request.DeleteCustomerRequest;
import tr.com.getir.book.customerservice.view.request.GetCustomerRequest;
import tr.com.getir.book.customerservice.view.request.UpdateCustomerRequest;
import tr.com.getir.book.customerservice.view.response.*;

public interface ICustomerService {

    CreateCustomerResponse createCustomer(CreateCustomerRequest request);

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request);

    DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest request);

    GetCustomerResponse getCustomer(GetCustomerRequest request);

    GetAllCustomersResponse getAllCustomers();

}
