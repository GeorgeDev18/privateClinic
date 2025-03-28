package com.privateclinic.presentation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDTO {

    private Long invoiceId;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDateTime date;

    @NotNull(message = "El total no puede ser nulo")
    @Positive(message = "El total debe ser un valor positivo")
    private BigDecimal total;

    @NotNull(message = "El ID de la cita médica no puede ser nulo")
    private Long appointmentId;
}