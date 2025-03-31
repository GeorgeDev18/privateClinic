
package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.MedicalPackage;
import com.privateclinic.persistence.entities.MedicalService;
import com.privateclinic.presentation.dto.MedicalPackageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper(componentModel = "spring")
public interface MedicalPackageMapper {

    MedicalPackageMapper INSTANCE = Mappers.getMapper(MedicalPackageMapper.class);

    MedicalPackageDTO toDTO(MedicalPackage medicalPackage);

    MedicalPackage toEntity(MedicalPackageDTO medicalPackageDTO);

    default List<Long> mapServices(MedicalPackage medicalPackage) {
        return medicalPackage.getServices().stream()
                .map(MedicalService::getServiceId)
                .toList();
    }
}
