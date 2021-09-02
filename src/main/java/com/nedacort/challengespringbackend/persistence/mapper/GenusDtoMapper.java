package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.GenusDto;
import com.nedacort.challengespringbackend.persistence.entity.Genero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenusDtoMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "imagen", target = "image")
    })
    GenusDto toGenusDto(Genero genero);

    List<GenusDto> toGenusDtos(List<Genero> generos);

    @InheritInverseConfiguration
    @Mapping(target = "peliculas", ignore = true)
    Genero toGenero(GenusDto genusDto);
}
