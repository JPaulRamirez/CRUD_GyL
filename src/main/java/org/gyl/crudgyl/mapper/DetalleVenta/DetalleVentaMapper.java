package org.gyl.crudgyl.mapper.DetalleVenta;

import org.gyl.crudgyl.dto.DetalleVenta.DetalleVentaResponseDto;
import org.gyl.crudgyl.dto.DetalleVenta.DetalleVentaRequestDto;
import org.gyl.crudgyl.entity.DetalleVenta.DetalleVenta;
import org.gyl.crudgyl.entity.Producto.Producto;
import org.gyl.crudgyl.entity.Venta.Venta;

public class DetalleVentaMapper {
    private DetalleVentaMapper() {}

    public static DetalleVenta toEntity(DetalleVentaRequestDto dto, Venta venta, Producto producto) {
        DetalleVenta detalleVenta = new DetalleVenta();

        detalleVenta.setCantidad(dto.cantidad());
        detalleVenta.setPrecio_unitario(producto.getPrecio());
        detalleVenta.setSubtotal(dto.cantidad() * producto.getPrecio());
        detalleVenta.setVenta(venta);
        detalleVenta.setProducto(producto);

        return detalleVenta;
    }
    public static DetalleVentaResponseDto toResponseDto(DetalleVenta detalleVenta) {
        return new DetalleVentaResponseDto(
                detalleVenta.getId_detalle_venta(),
                detalleVenta.getCantidad(),
                detalleVenta.getPrecio_unitario(),
                detalleVenta.getSubtotal(),
                detalleVenta.getVenta().getId_venta(),
                detalleVenta.getProducto().getId(),
                detalleVenta.getProducto().getNombre()
        );
    }
}
