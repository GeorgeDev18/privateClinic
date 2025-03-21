package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.Patient;
import com.privateclinic.presentation.dto.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



    @Mapper(componentModel = "spring")
    public interface PatientMapper {
        PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);


        PatientDTO toDTO(Patient patient);

        Patient toEntity(PatientDTO patientDTO);
    }


