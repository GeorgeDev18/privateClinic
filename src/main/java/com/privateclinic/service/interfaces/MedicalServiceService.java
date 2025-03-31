
package com.privateclinic.service.interfaces;

import com.privateclinic.presentation.dto.MedicalServiceDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MedicalServiceService {

    List<MedicalServiceDTO> getAllMedicalServices();

    Optional<MedicalServiceDTO> getMedicalServiceById(Long serviceId);

    MedicalServiceDTO saveMedicalService(MedicalServiceDTO medicalServiceDTO);

    MedicalServiceDTO updateMedicalService(Long serviceId, MedicalServiceDTO updatedServiceDTO);

    void deleteMedicalService(Long serviceId);

    Optional<MedicalServiceDTO> findMedicalServiceByCode(String serviceCode);

    List<MedicalServiceDTO> findMedicalServicesByName(String name);

    List<MedicalServiceDTO> findMedicalServicesByMaxPrice(BigDecimal price);
}

