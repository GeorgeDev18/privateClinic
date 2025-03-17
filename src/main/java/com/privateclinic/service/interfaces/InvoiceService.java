package com.privateclinic.service.interfaces;

import com.privateclinic.presentation.dto.InvoiceDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<InvoiceDTO> getAllInvoices();

    Optional<InvoiceDTO> getInvoiceById(Long invoiceId);

    InvoiceDTO saveInvoice(InvoiceDTO invoiceDTO);

    InvoiceDTO updateInvoice(Long invoiceId, InvoiceDTO updatedInvoiceDTO);

    void deleteInvoice(Long invoiceId);

    // Buscar una factura por el ID de la cita médica asociada
    Optional<InvoiceDTO> findInvoiceByAppointmentId(Long appointmentId);

    List<InvoiceDTO> findInvoicesByDate(LocalDateTime date);

    // Buscar facturas con un monto total mayor o igual a un valor específico
    List<InvoiceDTO> findInvoicesByMinTotal(BigDecimal total);
}