package com.privateclinic.service.implementation;

import com.privateclinic.mapper.PatientMapper;
import com.privateclinic.persistence.entities.Patient;
import com.privateclinic.presentation.dto.PatientDTO;
import com.privateclinic.service.interfaces.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.privateclinic.persistence.repository.PatientRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PatientDTO> getPatientById(Long patientId) {
        return patientRepository.findById(patientId)
                .map(patientMapper::toDTO);
    }

    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.toEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toDTO(savedPatient);
    }

    @Override
    @Transactional
    public PatientDTO updatePatient(Long patientId, PatientDTO updatedPatientDTO) {
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));

//        existingPatient.setName(updatedPatientDTO.getName());
//        existingPatient.setHasMedicalInsurance(updatedPatientDTO.getHasMedicalInsurance());

        Patient updatedPatient = patientRepository.save(existingPatient);
        return patientMapper.toDTO(updatedPatient);
    }

    @Override
    @Transactional
    public void deletePatient(Long patientId) {
        if (!patientRepository.existsById(patientId)) {
            throw new EntityNotFoundException("Patient not found with ID: " + patientId);
        }
        patientRepository.deleteById(patientId);
    }
}
