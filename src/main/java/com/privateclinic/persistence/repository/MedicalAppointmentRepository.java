package com.privateclinic.persistence.repository;

import com.privateclinic.persistence.entities.MedicalAppointment;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicalAppointmentRepository extends ListCrudRepository<MedicalAppointment, Long> {


    List<MedicalAppointment> findByDate(LocalDate date);

    List<MedicalAppointment> findByIsPaid(Boolean isPaid);

    List<MedicalAppointment> findByPatient_PatientId(Long patientId);

    List<MedicalAppointment> findByDoctor_DoctorId(Long doctorId);

}
