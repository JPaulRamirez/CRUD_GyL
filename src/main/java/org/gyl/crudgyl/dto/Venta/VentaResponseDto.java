package org.gyl.crudgyl.dto.Venta;

import java.time.LocalDate;

public record VentaResponseDto(

        Long id_venta,
        LocalDate fecha_venta,
        Double total,
        Long id_cliente,
        String nombre_cliente
) {

}
