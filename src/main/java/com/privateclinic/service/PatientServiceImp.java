package com.privateclinic.service;

import com.privateclinic.mapper.PatientMapper;
import com.privateclinic.persistence.entities.Patient;
import com.privateclinic.persistence.repository.PatientRepository;
import com.privateclinic.presentation.dto.PatientDTO;
import com.privateclinic.service.interfaces.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImp implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientServiceImp(PatientRepository patientRepository, PatientMapper patientMapper){
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<PatientDTO> getPatientById(Long patientId) {
        return patientRepository.findById(patientId)
                .map(patientMapper::toDTO);
    }

    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {
        if (patientDTO == null) {
            throw new IllegalArgumentException("PatientDTO must not be null");
        }
        Patient patient = patientMapper.toEntity(patientDTO);
        Patient savePatient = patientRepository.save(patient);
        return patientMapper.toDTO(savePatient);
    }

    @Override
    public PatientDTO updatePatient(Long patientId, PatientDTO updatedPatientDTO) {
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));

        existingPatient.setName(updatedPatientDTO.getName());
        existingPatient.setHasMedicalInsurance(updatedPatientDTO.getHasMedicalInsurance());

        Patient updatePatient = patientRepository.save(existingPatient);

        return patientMapper.toDTO(updatePatient);
    }

    @Override
    public void deletePatient(Long patientId) {
    if (!patientRepository.existsById(patientId)){
        throw new EntityNotFoundException("Patient not found with ID " + patientId);
    }
    patientRepository.deleteById(patientId);
    }
}
