package com.privateClinic.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    @Column(name = "invoice_id", nullable = false)
    private  Long invoiceId;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime date;

    @NotNull
    @Column(nullable = false)
    private BigDecimal total;

    @NotNull
    @OneToOne(targetEntity = MedicalAppointment.class)
    @JoinColumn(name = "appointment_id", nullable = false)
    private  MedicalAppointment medicalAppointment;
}
