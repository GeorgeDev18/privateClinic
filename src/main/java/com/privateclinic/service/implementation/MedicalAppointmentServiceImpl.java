
package com.privateclinic.service.implementation;

import com.privateclinic.mapper.MedicalAppointmentMapper;
import com.privateclinic.persistence.entities.MedicalAppointment;
import com.privateclinic.persistence.repository.MedicalAppointmentRepository;
import com.privateclinic.presentation.dto.MedicalAppointmentDTO;
import com.privateclinic.service.interfaces.MedicalAppointmentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class MedicalAppointmentServiceImpl implements MedicalAppointmentService {

    private final MedicalAppointmentRepository appointmentRepository;
    private final MedicalAppointmentMapper appointmentMapper;

    public MedicalAppointmentServiceImpl(MedicalAppointmentRepository appointmentRepository, MedicalAppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public List<MedicalAppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<MedicalAppointmentDTO> getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointmentMapper::toDTO);
    }

    @Override
    public MedicalAppointmentDTO saveAppointment(MedicalAppointmentDTO medicalAppointmentDTO) {
        MedicalAppointment appointment = appointmentMapper.toEntity(medicalAppointmentDTO);
        MedicalAppointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toDTO(savedAppointment);
    }

    @Override
    @Transactional
    public MedicalAppointmentDTO updateAppointment(Long appointmentId, MedicalAppointmentDTO updatedAppointmentDTO) {
        MedicalAppointment existingAppointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Medical Appointment not found with ID: " + appointmentId));

        existingAppointment.setDate(updatedAppointmentDTO.getDate());
        existingAppointment.setTime(updatedAppointmentDTO.getTime());
        existingAppointment.setTotal(updatedAppointmentDTO.getTotal());
        existingAppointment.setIsPaid(updatedAppointmentDTO.getIsPaid());

        MedicalAppointment updatedAppointment = appointmentRepository.save(existingAppointment);
        return appointmentMapper.toDTO(updatedAppointment);
    }

    @Override
    @Transactional
    public void deleteAppointment(Long appointmentId) {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new EntityNotFoundException("Medical Appointment not found with ID: " + appointmentId);
        }
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public List<MedicalAppointmentDTO> findAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findByDate(date)
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
    }

    @Override
    public List<MedicalAppointmentDTO> findAppointmentsByPaymentStatus(Boolean isPaid) {
        return appointmentRepository.findByIsPaid(isPaid)
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
    }

    @Override
    public List<MedicalAppointmentDTO> findAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatient_PatientId(patientId)
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
    }

    @Override
    public List<MedicalAppointmentDTO> findAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctor_DoctorId(doctorId)
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
    }
}
