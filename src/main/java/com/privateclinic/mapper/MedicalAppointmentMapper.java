package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.MedicalAppointment;
import com.privateclinic.presentation.dto.MedicalAppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface MedicalAppointmentMapper {

    MedicalAppointmentMapper INSTANCE = Mappers.getMapper(MedicalAppointmentMapper.class);

    @Mapping(source = "patient.patientId", target = "patientId")
    @Mapping(source = "doctor.doctorId", target = "doctorId")
    MedicalAppointmentDTO toDTO(MedicalAppointment medicalAppointment);

    @Mapping(source = "patientId", target = "patient.patientId")
    @Mapping(source = "doctorId", target = "doctor.doctorId")
    MedicalAppointment toEntity(MedicalAppointmentDTO medicalAppointmentDTO);
}