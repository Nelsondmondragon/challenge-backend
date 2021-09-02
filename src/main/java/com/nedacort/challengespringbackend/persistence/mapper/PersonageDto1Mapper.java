package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.PersonageDto1;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonageDto1Mapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "imagen", target = "image")
    })
    PersonageDto1 toPersonageDto1(Personaje personaje);
    List<PersonageDto1> toPersonageDto1S(List<Personaje> personajes);


}
