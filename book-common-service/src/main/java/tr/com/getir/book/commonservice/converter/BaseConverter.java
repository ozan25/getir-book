package tr.com.getir.book.commonservice.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.getir.book.commondomain.AuditingDto;
import tr.com.getir.book.commondomain.AuditingEntity;
import tr.com.getir.book.util.Util;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class BaseConverter<D extends AuditingDto, E extends AuditingEntity> {

    @Autowired
    protected ModelMapper modelMapper;

    public D toDto(E entity) {
        if (Util.isEmpty(entity)) {
            return null;
        }
        return modelMapper.map(entity, getDtoClass());
    }

    public E toEntity(D dto) {
        if (Util.isEmpty(dto)) {
            return null;
        }
        return modelMapper.map(dto, getEntityClass());
    }

    protected abstract Class<D> getDtoClass();

    protected abstract Class<E> getEntityClass();

    public List<E> toEntityList(List<D> dtos) {
        if (Util.isEmpty(dtos)) {
            return null;
        }
        List<E> entites = new ArrayList<E>();
        dtos.stream().forEach(d -> {
            E entity = toEntity(d);
            entites.add(entity);
        });
        return entites;
    }

    public List<D> toDtoList(List<E> entities) {
        if (Util.isEmpty(entities)) {
            return null;
        }
        List<D> dtos = new ArrayList<D>();
        entities.stream().forEach(e -> {
            D dto = toDto(e);
            dtos.add(dto);
        });
        return dtos;
    }

}