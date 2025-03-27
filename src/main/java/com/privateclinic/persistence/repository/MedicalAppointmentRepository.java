package com.privateclinic.persistence.repository;

import com.privateclinic.persistence.entities.MedicalAppointment;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicalAppointmentRepository extends ListCrudRepository<MedicalAppointment, Long> {


    List<MedicalAppointment> findByDate(LocalDate date);

    List<MedicalAppointment> findByIsPaid(Boolean isPaid);

    List<MedicalAppointment> findByPatient_PatientId(Long patientId);

    List<MedicalAppointment> findByDoctor_DoctorId(Long doctorId);

}