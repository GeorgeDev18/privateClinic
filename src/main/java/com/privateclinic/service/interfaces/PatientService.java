package com.privateclinic.service.interfaces;

import com.privateclinic.persistence.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> getAllPatients();

    Optional<Patient> getPatientById(Long patientId);

    Patient savePatient(Patient patient);

    Patient updatePatient(Long patientId, Patient updatedPatient);

    void deletePatient(Long patientId);

    List<Patient> findPatientsByMedicalInsuranceStatus(Boolean hasMedicalInsurance);
}
