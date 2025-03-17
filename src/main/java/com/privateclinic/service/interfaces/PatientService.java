package com.privateclinic.service.interfaces;

import com.privateclinic.presentation.dto.PatientDTO;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<PatientDTO> getAllPatients();

    Optional<PatientDTO> getPatientById(Long patientId);

    PatientDTO savePatient(PatientDTO patientDTO);

    PatientDTO updatePatient(Long patientId, PatientDTO updatedPatientDTO);

    void deletePatient(Long patientId);
}
