package com.privateclinic.service.interfaces;

import com.privateclinic.persistence.entities.Invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<Invoice> getAllInvoices();

    Optional<Invoice> getInvoiceById(Long invoiceId);

    Invoice saveInvoice(Invoice invoice);

    Invoice updateInvoice(Long invoiceId, Invoice updatedInvoice);

    void deleteInvoice(Long invoiceId);

    // Buscar una factura por el ID de la cita médica asociada
    Optional<Invoice> findInvoiceByAppointmentId(Long appointmentId);

    List<Invoice> findInvoicesByDate(LocalDateTime date);

    // Buscar facturas con un monto total mayor o igual a un valor específico
    List<Invoice> findInvoicesByMinTotal(BigDecimal total);
}
