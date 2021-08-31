package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonageDtoMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "imagen", target = "image"),
            @Mapping(source = "edad", target = "age"),
            @Mapping(source = "historia", target = "history")
    })
    PersonageDto toPersonageDto(Personaje personaje);

    List<PersonageDto> toPersonageDtos(List<Personaje> personajes);

    @InheritInverseConfiguration
    @Mapping(target = "personajePeliculas", ignore = true)
    Personaje toPersonaje(PersonageDto personageDto);
}
