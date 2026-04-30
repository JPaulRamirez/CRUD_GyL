package org.gyl.crudgyl.mapper.TipoProductoMapper;


import org.gyl.crudgyl.dto.TipoProducto.TipoProductoRequestDTO;
import org.gyl.crudgyl.dto.TipoProducto.TipoProductoResponseDTO;
import org.gyl.crudgyl.entity.TipoProducto.TipoProducto;

public class TipoProductoMapper {

    public static TipoProducto toEntity(TipoProductoRequestDTO dto)
    {
        TipoProducto tipoProducto = new TipoProducto();

        tipoProducto.setNombre(dto.nombre());
        tipoProducto.setDescripcion(dto.descripcion());

        return tipoProducto;
    }

    public static TipoProductoResponseDTO ToResponseDTO (TipoProducto tipoProducto){
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
