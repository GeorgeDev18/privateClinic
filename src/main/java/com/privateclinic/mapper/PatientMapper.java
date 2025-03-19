package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.Patient;
import com.privateclinic.presentation.dto.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



    @Mapper(componentModel = "spring")
    public interface PatientMapper {
        PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);


        @Mapping(target = "id", source = "id")
        @Mapping(target = "name", source = "name")
        @Mapping(target = "surname", source = "surname")
        @Mapping(target = "documentId", source = "documentId")
        @Mapping(target = "dateOfBirth", source = "dateOfBirth")
        @Mapping(target = "email", source = "email")
        @Mapping(target = "address", source = "address")
        @Mapping(target = "phoneNumber", source = "phoneNumber")
        @Mapping(target = "hasMedicalInsurance", source = "hasMedicalInsurance")
        PatientDTO toDTO(Patient patient);


        @Mapping(target = "id", source = "id")
        @Mapping(target = "name", source = "name")
        @Mapping(target = "surname", source = "surname")
        @Mapping(target = "documentId", source = "documentId")
        @Mapping(target = "dateOfBirth", source = "dateOfBirth")
        @Mapping(target = "email", source = "email")
        @Mapping(target = "address", source = "address")
        @Mapping(target = "phoneNumber", source = "phoneNumber")
        @Mapping(target = "hasMedicalInsurance", source = "hasMedicalInsurance")
        Patient toEntity(PatientDTO patientDTO);
    }


