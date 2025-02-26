package com.privateclinic.service.interfaces;

import com.privateclinic.persistence.entities.MedicalPackage;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MedicalPackageService {

    List<MedicalPackage> getAllMedicalPackages();

    Optional<MedicalPackage> getMedicalPackageById(Long packageId);

    MedicalPackage saveMedicalPackage(MedicalPackage medicalPackage);

    MedicalPackage updateMedicalPackage(Long packageId, MedicalPackage updatedPackage);

    void deleteMedicalPackage(Long packageId);

    Optional<MedicalPackage> findMedicalPackageByCode(String packageCode);

    List<MedicalPackage> findMedicalPackagesByName(String name);

    List<MedicalPackage> findMedicalPackagesByMaxPrice(BigDecimal price);

    List<MedicalPackage> findMedicalPackagesByDiscount(Integer discount);
}
