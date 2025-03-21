package com.privateclinic.persistence.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@ToString
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person {

    @Column(name = "has_medical_insurance")
    private  Boolean hasMedicalInsurance;


}



