package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.QualificationDto;
import com.nedacort.challengespringbackend.persistence.entity.Calificacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface QualificationMapper {
    @Mappings({
            @Mapping(source = "calificacion", target = "qualification")
    })
    QualificationDto toQualificationDto(Calificacion calificacion);
}
