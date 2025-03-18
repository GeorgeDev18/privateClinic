package com.privateclinic.service.interfaces;

import com.privateclinic.mapper.PatientMapper;
import com.privateclinic.persistence.repository.PatientRepository;
import com.privateclinic.presentation.dto.PatientDTO;
import com.privateclinic.service.PatientServiceImp;

import java.util.List;
import java.util.Optional;

public interface PatientService {


    List<PatientDTO> getAllPatients();

    Optional<PatientDTO> getPatientById(Long patientId);

    PatientDTO savePatient(PatientDTO patientDTO);

    PatientDTO updatePatient(Long patientId, PatientDTO updatedPatientDTO);

    void deletePatient(Long patientId);
}
