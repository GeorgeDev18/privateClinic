package com.privateclinic.persistence.repository;

import com.privateclinic.persistence.entities.MedicalPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MedicalPackageRepository extends ListCrudRepository<MedicalPackage,Long> {
    Optional<MedicalPackage> findByPackageCode(String packageCode);

    List<MedicalPackage> findByNameContainingIgnoreCase(String name);

    List<MedicalPackage> findByPriceLessThanEqual(BigDecimal price);

    List<MedicalPackage> findByDiscountGreaterThan(Integer discount);
}
