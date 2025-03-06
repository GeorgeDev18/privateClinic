package com.privateclinic.presentation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDTO {
    private Long id;

    @NotNull(message = "La especialidad no puede ser nula")
    @Size(min = 3, max = 50, message = "La especialidad debe tener entre 3 y 50 caracteres")
    private String speciality;

    @NotNull(message = "El turno no puede ser nulo")
    @Pattern(regexp = "^(Morning|Afternoon|Night)$", message = "El turno debe ser Mañana, Tarde o Noche")
    private String shift;

    @NotNull(message = "El salario no puede ser nulo")
    @Positive(message = "El salario debe ser un valor positivo")
    private BigDecimal salary;
}
