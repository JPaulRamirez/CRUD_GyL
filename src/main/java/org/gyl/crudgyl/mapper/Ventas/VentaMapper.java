package org.gyl.crudgyl.mapper.Ventas;

import org.gyl.crudgyl.dto.Venta.VentaRequestDto;
import org.gyl.crudgyl.dto.Venta.VentaResponseDto;
import org.gyl.crudgyl.entity.Cliente.Cliente;
import org.gyl.crudgyl.entity.Venta.Venta;

public class VentaMapper {
    private VentaMapper() {}

    public static Venta toEntity(VentaRequestDto dto, Cliente cliente) {
        Venta venta = new Venta();
        venta.setFecha_venta(dto.fecha_venta());
        venta.setTotal(dto.total());
        venta.setCliente(cliente);
        return venta;
    }

    public static VentaResponseDto toResponseDto(Venta venta) {
        return new VentaResponseDto(
                venta.getId_venta(),
                venta.getFecha_venta(),
                venta.getTotal(),
                venta.getCliente().getId_cliente(),
                venta.getCliente().getNombre() + " " + venta.getCliente().getApellido()
        );
    }
}
