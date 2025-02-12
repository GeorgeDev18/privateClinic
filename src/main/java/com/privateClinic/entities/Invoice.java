package com.privateClinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "invoice_id")
    private  long invoiceId;

    @Column(columnDefinition = "DATE")
    private LocalDateTime date;

    private BigDecimal total;


    @OneToOne(targetEntity = MedicalAppointment.class)
    @JoinColumn(name = "appointment_id", nullable = false)
    private  MedicalAppointment medicalAppointment;
}
