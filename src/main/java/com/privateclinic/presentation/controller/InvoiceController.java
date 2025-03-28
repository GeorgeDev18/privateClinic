package com.privateclinic.presentation.controller;

import com.privateclinic.presentation.dto.InvoiceDTO;
import com.privateclinic.service.implementation.InvoiceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceServiceImpl invoiceServiceImpl;

    public InvoiceController(InvoiceServiceImpl invoiceServiceImpl) {
        this.invoiceServiceImpl = invoiceServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices() {
        List<InvoiceDTO> invoices = invoiceServiceImpl.getAllInvoices();
        return invoices.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id) {
        Optional<InvoiceDTO> invoice = invoiceServiceImpl.getInvoiceById(id);
        return invoice.map(invoiceDTO -> new ResponseEntity<>(invoiceDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {
        InvoiceDTO savedInvoice = invoiceServiceImpl.saveInvoice(invoiceDTO);
        return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDTO> updateInvoice(
            @PathVariable Long id,
            @Valid @RequestBody InvoiceDTO invoiceDTO
    ) {
        InvoiceDTO updatedInvoice = invoiceServiceImpl.updateInvoice(id, invoiceDTO);
        return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceServiceImpl.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<InvoiceDTO> getInvoiceByAppointmentId(@PathVariable Long appointmentId) {
        Optional<InvoiceDTO> invoice = invoiceServiceImpl.findInvoiceByAppointmentId(appointmentId);
        return invoice.map(invoiceDTO -> new ResponseEntity<>(invoiceDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByDate(@PathVariable LocalDateTime date) {
        List<InvoiceDTO> invoices = invoiceServiceImpl.findInvoicesByDate(date);
        return invoices.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/total/min/{total}")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByMinTotal(@PathVariable BigDecimal total) {
        List<InvoiceDTO> invoices = invoiceServiceImpl.findInvoicesByMinTotal(total);
        return invoices.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(invoices, HttpStatus.OK);
    }
}