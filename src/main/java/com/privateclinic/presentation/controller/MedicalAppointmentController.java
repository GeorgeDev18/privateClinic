package com.privateclinic.presentation.controller;

import com.privateclinic.presentation.dto.MedicalAppointmentDTO;
import com.privateclinic.service.implementation.MedicalAppointmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class MedicalAppointmentController {

    private final MedicalAppointmentServiceImpl appointmentService;

    public MedicalAppointmentController(MedicalAppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<MedicalAppointmentDTO>> getAllAppointments() {
        List<MedicalAppointmentDTO> appointments = appointmentService.getAllAppointments();
        return appointments.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalAppointmentDTO> getAppointmentById(@PathVariable Long id) {
        Optional<MedicalAppointmentDTO> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MedicalAppointmentDTO> createAppointment(@Valid @RequestBody MedicalAppointmentDTO appointmentDTO) {
        MedicalAppointmentDTO savedAppointment = appointmentService.saveAppointment(appointmentDTO);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalAppointmentDTO> updateAppointment(@PathVariable Long id, @Valid @RequestBody MedicalAppointmentDTO appointmentDTO) {
        MedicalAppointmentDTO updatedAppointment = appointmentService.updateAppointment(id, appointmentDTO);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<MedicalAppointmentDTO>> getAppointmentsByDate(@PathVariable LocalDate date) {
        List<MedicalAppointmentDTO> appointments = appointmentService.findAppointmentsByDate(date);
        return appointments.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/payment-status/{isPaid}")
    public ResponseEntity<List<MedicalAppointmentDTO>> getAppointmentsByPaymentStatus(@PathVariable Boolean isPaid) {
        List<MedicalAppointmentDTO> appointments = appointmentService.findAppointmentsByPaymentStatus(isPaid);
        return appointments.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalAppointmentDTO>> getAppointmentsByPatient(@PathVariable Long patientId) {
        List<MedicalAppointmentDTO> appointments = appointmentService.findAppointmentsByPatient(patientId);
        return appointments.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<MedicalAppointmentDTO>> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        List<MedicalAppointmentDTO> appointments = appointmentService.findAppointmentsByDoctor(doctorId);
        return appointments.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
