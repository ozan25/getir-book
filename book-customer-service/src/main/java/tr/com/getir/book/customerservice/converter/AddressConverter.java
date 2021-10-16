package tr.com.getir.book.customerservice.converter;

import org.springframework.stereotype.Component;
import tr.com.getir.book.commonservice.converter.BaseConverter;
import tr.com.getir.book.customerdomain.entity.Address;
import tr.com.getir.book.customerservice.view.model.AddressDto;

@Component
public class AddressConverter extends BaseConverter<AddressDto, Address> {
    @Override
    protected Class<AddressDto> getDtoClass() {
        return AddressDto.class;
    }

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }
}
