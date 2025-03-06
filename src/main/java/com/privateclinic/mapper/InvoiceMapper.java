package com.privateclinic.mapper;

import com.privateclinic.persistence.entities.Invoice;
import com.privateclinic.presentation.dto.InvoiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    @Mapping(source = "medicalAppointment.appointmentId", target = "appointmentId")
    InvoiceDTO toDTO(Invoice invoice);

    @Mapping(source = "appointmentId", target = "medicalAppointment.appointmentId")
    Invoice toEntity(InvoiceDTO invoiceDTO);
}
