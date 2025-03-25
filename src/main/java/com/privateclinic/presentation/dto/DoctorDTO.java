package com.privateclinic.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DoctorDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    private String surname;

    @NotBlank(message = "El documento de identidad es obligatorio")
    private String documentId;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate dateOfBirth;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    private String email;

    @NotBlank(message = "La dirección es obligatoria")
    private String address;

    @NotNull(message = "El número de teléfono es obligatorio")
    private Long phoneNumber;

    @NotBlank(message = "La especialidad no puede ser nula")
    @Size(min = 3, max = 50, message = "La especialidad debe tener entre 3 y 50 caracteres")
    private String speciality;

    @NotBlank(message = "El turno no puede ser nulo")
    @Pattern(regexp = "^(Mañana|Tarde|Noche)$", message = "El turno debe ser Mañana, Tarde o Noche")
    private String shift;

    @NotNull(message = "El salario no puede ser nulo")
    @Positive(message = "El salario debe ser un valor positivo")
    private BigDecimal salary;
}
