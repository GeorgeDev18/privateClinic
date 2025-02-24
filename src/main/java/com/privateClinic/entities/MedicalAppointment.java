package com.privateClinic.entities;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name= "medical_appointment")
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "appointment_id")
    private Long appointmentId;

    @NotNull
    @Column(nullable = false)
    private LocalDate date;

    @NotNull
    @Column(nullable = false)
    private LocalTime time;

    @NotNull
    @Column(nullable = false)
    private BigDecimal total;

    @NotNull
    @Column(name = "is_paid",nullable = false)
    private  Boolean isPaid;

    @NotNull
    @ManyToOne(targetEntity = MedicalService.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_service_id", nullable = false)
    private MedicalService medicalService;

    @NotNull
    @ManyToOne(targetEntity = MedicalPackage.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_package_id", nullable = false)
    private  MedicalPackage medicalPackage;

    @NotNull
    @ManyToOne(targetEntity = Patient.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private  Patient patient;

    @NotNull
    @ManyToOne(targetEntity = Doctor.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private  Doctor doctor;

}
