package com.privateclinic.persistence.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Patient extends Person {

    @Id
    @Column(name = "id_patient", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "has_medical_insurance")
    private  Boolean hasMedicalInsurance;
}
