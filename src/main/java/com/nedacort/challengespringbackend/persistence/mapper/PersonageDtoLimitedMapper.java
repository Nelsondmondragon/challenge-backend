package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.PersonageDtoLimited;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonageDtoLimitedMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "imagen", target = "image")
    })
    PersonageDtoLimited toPersonageDtoLimited(Personaje personaje);

    List<PersonageDtoLimited> toPersonageDtoLimiteds(List<Personaje> personajes);


}
