package tr.com.getir.book.customerservice.converter;

import org.springframework.stereotype.Component;
import tr.com.getir.book.commonservice.converter.BaseConverter;
import tr.com.getir.book.customerdomain.entity.Customer;
import tr.com.getir.book.customerservice.view.model.CustomerDto;

@Component
public class CustomerConverter extends BaseConverter<CustomerDto, Customer> {
    @Override
    protected Class<CustomerDto> getDtoClass() {
        return CustomerDto.class;
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
