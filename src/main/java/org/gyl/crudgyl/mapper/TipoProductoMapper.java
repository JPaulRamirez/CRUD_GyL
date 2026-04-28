package org.gyl.crudgyl.mapper;

import org.gyl.crudgyl.dto.ProductoResponseDTO;
import org.gyl.crudgyl.dto.TipoProductoRequestDTO;
import org.gyl.crudgyl.dto.TipoProductoResponseDTO;
import org.gyl.crudgyl.entity.TipoProducto;

public class TipoProductoMapper {

    public static TipoProducto toEntity(TipoProductoRequestDTO dto)
    {
        TipoProducto tipoProducto = new TipoProducto();

        tipoProducto.setNombre(dto.nombre());
        tipoProducto.setDescripcion(dto.descripcion());

        return tipoProducto;
    }

    public static TipoProductoResponseDTO productoResponseDTO (TipoProducto tipoProducto){
        return new TipoProductoResponseDTO(
                tipoProducto.getId_tipo_producto(),
                tipoProducto.getNombre(),
                tipoProducto.getDescripcion()
        );
    }

    public static void updateEntity(TipoProducto tipoProducto, TipoProductoRequestDTO dto)
    {
        tipoProducto.setNombre(dto.nombre());
        tipoProducto.setDescripcion(dto.descripcion());
    }

}
