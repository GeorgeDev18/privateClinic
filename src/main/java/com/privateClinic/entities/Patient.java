package com.privateClinic.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "has_medical_insurance")
    private  Boolean hasMedicalInsurance;


}
