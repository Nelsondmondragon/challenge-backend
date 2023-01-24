package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.GenderDto;
import com.nedacort.challengespringbackend.persistense.entities.Gender;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    GenderDto toGenderDto(Gender gender);
    List<GenderDto> toGenusDtos(List<Gender> genders);
    @InheritInverseConfiguration
    Gender toGender(GenderDto gender);
}
