package org.gyl.crudgyl.mapper;

import org.gyl.crudgyl.dto.ProductoDto.ProductoRequestDTO;
import org.gyl.crudgyl.dto.ProductoDto.ProductoResponseDTO;
import org.gyl.crudgyl.entity.Producto;

public class ProductoMapper {
    private ProductoMapper(){}

    public static Producto toEntity(ProductoRequestDTO dto){
        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
        return producto;
    }

    public static ProductoResponseDTO toResponseDTO(Producto producto){
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getId_tipo_producto().getId_tipo_producto()/*SEGUIR CON ESTO PARA*/
        );
    }

    public static void updateEntity(Producto producto, ProductoRequestDTO dto){
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
    }
}
