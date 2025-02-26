package com.privateclinic.persistence.repository;

import com.privateclinic.persistence.entities.MedicalService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MedicalServiceRepository extends ListCrudRepository<MedicalService, Long> {

    Optional<MedicalService> findByServiceCode(String serviceCode);

    List<MedicalService> findByNameContainingIgnoreCase(String name);

    List<MedicalService> findByPriceLessThanEqual(BigDecimal price);

}
