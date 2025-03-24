package com.privateclinic.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person{

    @Id
    @Column(name = "id_doctor", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
    @SequenceGenerator(name = "doctor_seq", sequenceName = "doctor_sequence", allocationSize = 1)
    private Long idDoctor;

    private String speciality;

    private String shift;

    private BigDecimal salary;
}


