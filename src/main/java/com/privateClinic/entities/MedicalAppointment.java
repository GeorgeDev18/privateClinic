package com.privateClinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "medical_appointment")
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "appointment_id")
    private long appointmentId;

    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @Column(columnDefinition = "TIME")
    private LocalTime time;

    private BigDecimal total;

    @Column(name = "is_it_paid")
    private  Boolean isItPaid;

    @ManyToOne(targetEntity = MedicalService.class)
    @JoinColumn(name = "medical_service_id", nullable = false)
    private MedicalService medicalService;

    @ManyToOne(targetEntity = MedicalPackage.class)
    @JoinColumn(name = "medical_package_id", nullable = false)
    private  MedicalPackage medicalPackage;

    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id", nullable = false)
    private  Patient patient;

    @ManyToOne(targetEntity = Doctor.class)
    @JoinColumn(name = "doctor_id", nullable = false)
    private  Doctor doctor;

}
