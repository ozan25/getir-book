package tr.com.getir.book.commonservice.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tr.com.getir.book.commondomain.AuditingDto;
import tr.com.getir.book.commondomain.AuditingEntity;

@Configuration
public class CommonServiceBeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<AuditingDto, AuditingEntity>() {
            @Override
            protected void configure() {
                skip(destination.getCreatedBy());
                skip(destination.getCreatedDate());
                skip(destination.getLastModifiedBy());
                skip(destination.getLastModifiedDate());
            }
        });
        modelMapper.addMappings(new PropertyMap<AuditingEntity, AuditingDto>() {
            @Override
            protected void configure() {
                skip(destination.getCreatedBy());
                skip(destination.getCreatedDate());
                skip(destination.getLastModifiedBy());
                skip(destination.getLastModifiedDate());
            }
        });
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
    }
}
