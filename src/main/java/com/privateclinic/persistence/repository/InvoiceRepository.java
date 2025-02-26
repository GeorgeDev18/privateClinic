package com.privateclinic.persistence.repository;

import com.privateclinic.persistence.entities.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends ListCrudRepository<Invoice,Long> {

    Optional<Invoice> findByMedicalAppointment_AppointmentId(Long appointmentId);

    List<Invoice> findByDate(LocalDateTime date);

    List<Invoice> findByTotalGreaterThanEqual(BigDecimal total);

}
