package com.privateclinic.presentation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalAppointmentDTO {

    private Long id;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate date;

    @NotNull(message = "La hora no puede ser nula")
    private LocalTime time;

    @NotNull(message = "El total no puede ser nulo")
    @Positive(message = "El total debe ser un valor positivo")
    private BigDecimal total;

    @NotNull(message = "El estado de pago no puede ser nulo")
    private Boolean isPaid;

    @NotNull(message = "Debe especificar el ID del paciente")
    private Long patientId;

    @NotNull(message = "Debe especificar el ID del doctor")
    private Long doctorId;
}
