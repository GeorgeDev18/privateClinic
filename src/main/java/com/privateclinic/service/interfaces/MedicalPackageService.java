package com.privateclinic.service.interfaces;

import com.privateclinic.presentation.dto.MedicalPackageDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MedicalPackageService {

    List<MedicalPackageDTO> getAllMedicalPackages();

    Optional<MedicalPackageDTO> getMedicalPackageById(Long packageId);

    MedicalPackageDTO saveMedicalPackage(MedicalPackageDTO medicalPackageDTO);

    MedicalPackageDTO updateMedicalPackage(Long packageId, MedicalPackageDTO updatedPackageDTO);

    void deleteMedicalPackage(Long packageId);

    Optional<MedicalPackageDTO> findMedicalPackageByCode(String packageCode);

    List<MedicalPackageDTO> findMedicalPackagesByName(String name);

    List<MedicalPackageDTO> findMedicalPackagesByMaxPrice(BigDecimal price);

    List<MedicalPackageDTO> findMedicalPackagesByDiscount(Integer discount);
}
