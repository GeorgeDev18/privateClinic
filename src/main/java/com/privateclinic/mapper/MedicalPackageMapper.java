package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.MedicalPackage;
import com.privateclinic.presentation.dto.MedicalPackageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MedicalPackageMapper {

    MedicalPackageMapper INSTANCE = Mappers.getMapper(MedicalPackageMapper.class);

    @Mapping(target = "serviceIds", expression = "java(mapServices(medicalPackage))")
    MedicalPackageDTO toDTO(MedicalPackage medicalPackage);

    @Mapping(target = "services", ignore = true) // Evitamos cargar la lista completa
    MedicalPackage toEntity(MedicalPackageDTO medicalPackageDTO);

    default List<Long> mapServices(MedicalPackage medicalPackage) {
        return medicalPackage.getServices().stream()
                .map(service -> service.getServiceId())
                .collect(Collectors.toList());
    }
}
