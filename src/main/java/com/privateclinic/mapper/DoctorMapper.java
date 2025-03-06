package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.Doctor;
import com.privateclinic.presentation.dto.DoctorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    // Convierte de entidad a DTO
    DoctorDTO toDTO(Doctor doctor);

    // Convierte de DTO a entidad
    Doctor toEntity(DoctorDTO doctorDTO);
}
