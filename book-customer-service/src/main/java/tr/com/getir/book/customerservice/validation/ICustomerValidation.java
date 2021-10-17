package tr.com.getir.book.customerservice.validation;

import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerservice.view.model.CustomerDto;

public interface ICustomerValidation {

    Customer validateCustomer(final String customerId);

    CustomerDto validateCustomer(final CustomerDto customerDto);

    Customer validateCustomer(final Customer customer);

}
