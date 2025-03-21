package com.privateclinic.persistence.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Patient extends Person {

    @Column(name = "has_medical_insurance")
    private  Boolean hasMedicalInsurance;


}
