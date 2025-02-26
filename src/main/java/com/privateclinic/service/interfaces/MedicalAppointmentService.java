package com.privateclinic.service.interfaces;

import com.privateclinic.persistence.entities.MedicalAppointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MedicalAppointmentService {

    List<MedicalAppointment> getAllAppointments();

    Optional<MedicalAppointment> getAppointmentById(Long appointmentId);

    MedicalAppointment saveAppointment(MedicalAppointment medicalAppointment);

    MedicalAppointment updateAppointment(Long appointmentId, MedicalAppointment updatedAppointment);

    void deleteAppointment(Long appointmentId);

    List<MedicalAppointment> findAppointmentsByDate(LocalDate date);

    List<MedicalAppointment> findAppointmentsByPaymentStatus(Boolean isPaid);

    List<MedicalAppointment> findAppointmentsByPatient(Long patientId);

    List<MedicalAppointment> findAppointmentsByDoctor(Long doctorId);
}
