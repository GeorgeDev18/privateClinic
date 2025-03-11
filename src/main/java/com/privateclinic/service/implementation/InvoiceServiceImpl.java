package com.privateclinic.service.implementation;

import com.privateclinic.mapper.InvoiceMapper;
import com.privateclinic.persistence.entities.Invoice;
import com.privateclinic.persistence.repository.InvoiceRepository;
import com.privateclinic.presentation.dto.InvoiceDTO;
import com.privateclinic.service.interfaces.InvoiceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InvoiceDTO> getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .map(invoiceMapper::toDTO);
    }

    @Override
    public InvoiceDTO saveInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDTO(savedInvoice);
    }

    @Override
    @Transactional
    public InvoiceDTO updateInvoice(Long invoiceId, InvoiceDTO updatedInvoiceDTO) {
        Invoice existingInvoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found with ID: " + invoiceId));

//        existingInvoice.setDate(updatedInvoiceDTO.getDate());
//        existingInvoice.setTotal(updatedInvoiceDTO.getTotal());

        Invoice updatedInvoice = invoiceRepository.save(existingInvoice);
        return invoiceMapper.toDTO(updatedInvoice);
    }

    @Override
    @Transactional
    public void deleteInvoice(Long invoiceId) {
        if (!invoiceRepository.existsById(invoiceId)) {
            throw new EntityNotFoundException("Invoice not found with ID: " + invoiceId);
        }
        invoiceRepository.deleteById(invoiceId);
    }

    @Override
    public Optional<InvoiceDTO> findInvoiceByAppointmentId(Long appointmentId) {
        return invoiceRepository.findByMedicalAppointment_AppointmentId(appointmentId)
                .map(invoiceMapper::toDTO);
    }

    @Override
    public List<InvoiceDTO> findInvoicesByDate(LocalDateTime date) {
        return invoiceRepository.findByDate(date)
                .stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> findInvoicesByMinTotal(BigDecimal total) {
        return invoiceRepository.findByTotalGreaterThanEqual(total)
                .stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

}
