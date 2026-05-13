package org.gyl.crudgyl.dto.detalleVenta;

public record DetalleVentaResponseDto(
        Long id_detalle_venta,
        Integer cantidad,
        Double precio_unitario,
        Double subtotal,
        Long id_venta,
        Long id_producto,
        String nombre_producto
) {
}
