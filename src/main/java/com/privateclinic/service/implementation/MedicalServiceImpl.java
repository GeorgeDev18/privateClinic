package com.privateclinic.service.implementation;

import com.privateclinic.mapper.MedicalServiceMapper;
import com.privateclinic.persistence.entities.MedicalService;
import com.privateclinic.persistence.repository.MedicalServiceRepository;
import com.privateclinic.presentation.dto.MedicalServiceDTO;
import com.privateclinic.service.interfaces.MedicalServiceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicalServiceImpl implements MedicalServiceService {

    private final MedicalServiceRepository medicalServiceRepository;
    private final MedicalServiceMapper medicalServiceMapper;

    public MedicalServiceImpl(MedicalServiceRepository medicalServiceRepository, MedicalServiceMapper medicalServiceMapper) {
        this.medicalServiceRepository = medicalServiceRepository;
        this.medicalServiceMapper = medicalServiceMapper;
    }

    @Override
    public List<MedicalServiceDTO> getAllMedicalServices() {
        return medicalServiceRepository.findAll()
                .stream()
                .map(medicalServiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MedicalServiceDTO> getMedicalServiceById(Long serviceId) {
        return medicalServiceRepository.findById(serviceId)
                .map(medicalServiceMapper::toDTO);
    }

    @Override
    public MedicalServiceDTO saveMedicalService(MedicalServiceDTO medicalServiceDTO) {
        MedicalService medicalService = medicalServiceMapper.toEntity(medicalServiceDTO);
        MedicalService savedService = medicalServiceRepository.save(medicalService);
        return medicalServiceMapper.toDTO(savedService);
    }

    @Override
    @Transactional
    public MedicalServiceDTO updateMedicalService(Long serviceId, MedicalServiceDTO updatedServiceDTO) {
        MedicalService existingService = medicalServiceRepository.findById(serviceId)
                .orElseThrow(() -> new EntityNotFoundException("Medical Service not found with ID: " + serviceId));

        existingService.setServiceCode(updatedServiceDTO.getServiceCode());
        existingService.setName(updatedServiceDTO.getName());
        existingService.setDescription(updatedServiceDTO.getDescription());
        existingService.setPrice(updatedServiceDTO.getPrice());

        MedicalService updatedService = medicalServiceRepository.save(existingService);
        return medicalServiceMapper.toDTO(updatedService);
    }

    @Override
    @Transactional
    public void deleteMedicalService(Long serviceId) {
        if (!medicalServiceRepository.existsById(serviceId)) {
            throw new EntityNotFoundException("Medical Service not found with ID: " + serviceId);
        }
        medicalServiceRepository.deleteById(serviceId);
    }

    @Override
    public Optional<MedicalServiceDTO> findMedicalServiceByCode(String serviceCode) {
        return medicalServiceRepository.findByServiceCode(serviceCode)
                .map(medicalServiceMapper::toDTO);
    }

    @Override
    public List<MedicalServiceDTO> findMedicalServicesByName(String name) {
        return medicalServiceRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(medicalServiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalServiceDTO> findMedicalServicesByMaxPrice(BigDecimal price) {
        return medicalServiceRepository.findByPriceLessThanEqual(price)
                .stream()
                .map(medicalServiceMapper::toDTO)
                .collect(Collectors.toList());
    }
}
