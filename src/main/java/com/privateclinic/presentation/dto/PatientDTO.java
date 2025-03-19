package com.privateclinic.presentation.dto;



import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {

    private Long id;


    private String name;


    private String surname;


    private String documentId;


    private LocalDate dateOfBirth;


    private String email;


    private String address;


    private Long phoneNumber;

    private Boolean hasMedicalInsurance;

}
