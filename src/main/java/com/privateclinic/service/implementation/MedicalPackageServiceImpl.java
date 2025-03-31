
package com.privateclinic.service.implementation;

import com.privateclinic.mapper.MedicalPackageMapper;
import com.privateclinic.persistence.entities.MedicalPackage;
import com.privateclinic.persistence.repository.MedicalPackageRepository;
import com.privateclinic.presentation.dto.MedicalPackageDTO;
import com.privateclinic.service.interfaces.MedicalPackageService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicalPackageServiceImpl implements MedicalPackageService {

    private final MedicalPackageRepository medicalPackageRepository;
    private final MedicalPackageMapper medicalPackageMapper;

    public MedicalPackageServiceImpl(MedicalPackageRepository medicalPackageRepository, MedicalPackageMapper medicalPackageMapper) {
        this.medicalPackageRepository = medicalPackageRepository;
        this.medicalPackageMapper = medicalPackageMapper;
    }

    @Override
    public List<MedicalPackageDTO> getAllMedicalPackages() {
        return medicalPackageRepository.findAll()
                .stream()
                .map(medicalPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MedicalPackageDTO> getMedicalPackageById(Long packageId) {
        return medicalPackageRepository.findById(packageId)
                .map(medicalPackageMapper::toDTO);
    }

    @Override
    public MedicalPackageDTO saveMedicalPackage(MedicalPackageDTO medicalPackageDTO) {
        MedicalPackage medicalPackage = medicalPackageMapper.toEntity(medicalPackageDTO);
        MedicalPackage savedPackage = medicalPackageRepository.save(medicalPackage);
        return medicalPackageMapper.toDTO(savedPackage);
    }

    @Override
    @Transactional
    public MedicalPackageDTO updateMedicalPackage(Long packageId, MedicalPackageDTO updatedPackageDTO) {
        MedicalPackage existingPackage = medicalPackageRepository.findById(packageId)
                .orElseThrow(() -> new EntityNotFoundException("Medical Package not found with ID: " + packageId));

        existingPackage.setPackageCode(updatedPackageDTO.getPackageCode());
        existingPackage.setName(updatedPackageDTO.getName());
        existingPackage.setPrice(updatedPackageDTO.getPrice());
        existingPackage.setDiscount(updatedPackageDTO.getDiscount());

        MedicalPackage updatedPackage = medicalPackageRepository.save(existingPackage);
        return medicalPackageMapper.toDTO(updatedPackage);
    }

    @Override
    @Transactional
    public void deleteMedicalPackage(Long packageId) {
        if (!medicalPackageRepository.existsById(packageId)) {
            throw new EntityNotFoundException("Medical Package not found with ID: " + packageId);
        }
        medicalPackageRepository.deleteById(packageId);
    }

    @Override
    public Optional<MedicalPackageDTO> findMedicalPackageByCode(String packageCode) {
        return medicalPackageRepository.findByPackageCode(packageCode)
                .map(medicalPackageMapper::toDTO);
    }

    @Override
    public List<MedicalPackageDTO> findMedicalPackagesByName(String name) {
        return medicalPackageRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(medicalPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalPackageDTO> findMedicalPackagesByMaxPrice(BigDecimal price) {
        return medicalPackageRepository.findByPriceLessThanEqual(price)
                .stream()
                .map(medicalPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalPackageDTO> findMedicalPackagesByDiscount(Integer discount) {
        return medicalPackageRepository.findByDiscountGreaterThan(discount)
                .stream()
                .map(medicalPackageMapper::toDTO)
                .collect(Collectors.toList());
    }
}

