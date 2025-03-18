package com.privateclinic.presentation.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private Long documentId;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String email;

    @NotNull
    private String address;

    @NotNull
    private Long phoneNumber;

    private Boolean hasMedicalInsurance;

}
