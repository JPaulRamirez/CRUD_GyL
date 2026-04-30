package org.gyl.crudgyl.dto.DetalleVenta;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
public record DetalleVentaRequestDto(
        @NotNull(message = "La cantidad es obligatoria")
        @Min(value = 1, message = "La cantidad debe ser mayor a 0")
        Integer cantidad,

        @NotNull(message = "La venta es obligatoria")
        Long id_venta,

        @NotNull(message = "El producto es obligatorio")
        Long id_producto
) {
}
