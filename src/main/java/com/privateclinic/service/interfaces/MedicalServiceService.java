package com.privateclinic.service.interfaces;

import com.privateclinic.persistence.entities.MedicalService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MedicalServiceService {

    List<MedicalService> getAllMedicalServices();

    Optional<MedicalService> getMedicalServiceById(Long serviceId);

    MedicalService saveMedicalService(MedicalService medicalService);


    MedicalService updateMedicalService(Long serviceId, MedicalService updatedService);

    void deleteMedicalService(Long serviceId);

    Optional<MedicalService> findMedicalServiceByCode(String serviceCode);

    List<MedicalService> findMedicalServicesByName(String name);

    List<MedicalService> findMedicalServicesByMaxPrice(BigDecimal price);
}
