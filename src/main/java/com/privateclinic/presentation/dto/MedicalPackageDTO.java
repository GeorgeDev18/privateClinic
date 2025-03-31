
package com.privateclinic.presentation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalPackageDTO {

    private Long id;

    @NotNull(message = "El código del paquete no puede ser nulo")
    @Size(min = 3, max = 20, message = "El código debe tener entre 3 y 20 caracteres")
    private String packageCode;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String name;

    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser un valor positivo")
    private BigDecimal price;

    @NotNull(message = "El descuento no puede ser nulo")
    @Positive(message = "El descuento debe ser un número positivo")
    private Integer discount;

    private List<Long> serviceIds; // Solo lista de IDs para evitar carga de relaciones completas
}
