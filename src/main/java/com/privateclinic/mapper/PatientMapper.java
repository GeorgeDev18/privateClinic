package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.Patient;
import com.privateclinic.presentation.dto.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



    @Mapper(componentModel = "spring")
    public interface PatientMapper {
        PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

        @Mapping(target = "name", source = "name")
        PatientDTO toDTO(Patient patient);


        @Mapping(target = "name", source = "name")
        Patient toEntity(PatientDTO patientDTO);
    }


