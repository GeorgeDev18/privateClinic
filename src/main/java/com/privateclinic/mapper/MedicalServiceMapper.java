package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.MedicalService;
import com.privateclinic.presentation.dto.MedicalServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicalServiceMapper {


    MedicalServiceMapper INSTANCE = Mappers.getMapper(MedicalServiceMapper.class);

    MedicalServiceDTO toDTO(MedicalService medicalService);

    MedicalService toEntity(MedicalServiceDTO medicalServiceDTO);
}
