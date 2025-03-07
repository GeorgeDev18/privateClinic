package com.privateclinic.service.interfaces;

import com.privateclinic.persistence.entities.MedicalAppointment;
import com.privateclinic.presentation.dto.MedicalAppointmentDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MedicalAppointmentService {

    List<MedicalAppointmentDTO> getAllAppointments();

    Optional<MedicalAppointmentDTO> getAppointmentById(Long appointmentId);

    MedicalAppointmentDTO saveAppointment(MedicalAppointmentDTO medicalAppointmentDTO);

    MedicalAppointmentDTO updateAppointment(Long appointmentId, MedicalAppointmentDTO updatedAppointmentDTO);

    void deleteAppointment(Long appointmentId);

    List<MedicalAppointmentDTO> findAppointmentsByDate(LocalDate date);

    List<MedicalAppointmentDTO> findAppointmentsByPaymentStatus(Boolean isPaid);

    List<MedicalAppointmentDTO> findAppointmentsByPatient(Long patientId);

    List<MedicalAppointmentDTO> findAppointmentsByDoctor(Long doctorId);
}
