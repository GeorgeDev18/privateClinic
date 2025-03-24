package com.privateclinic.persistence.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person {

    @Id
    @Column(name = "id_patient", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_sequence", allocationSize = 1)
    private Long idPatient;

    @Column(name = "has_medical_insurance")
    private  Boolean hasMedicalInsurance;
}
