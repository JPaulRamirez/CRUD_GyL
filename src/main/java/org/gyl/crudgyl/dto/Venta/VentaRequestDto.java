package org.gyl.crudgyl.dto.Venta;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record VentaRequestDto(

        @NotNull(message = "La fecha no puede estar vacio")
        LocalDate fecha_venta,
        @NotNull(message = "El total no puede estar vacio")
        @PositiveOrZero(message = "El total no puede ser negativo")
        Double total,

        @NotNull(message = "El cliente es obligatorio")
        Long id_cliente
) {
}
