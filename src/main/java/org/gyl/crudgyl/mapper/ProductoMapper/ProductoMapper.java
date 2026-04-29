package org.gyl.crudgyl.mapper.ProductoMapper;

import org.gyl.crudgyl.dto.ProductoDto.ProductoRequestDTO;
import org.gyl.crudgyl.dto.ProductoDto.ProductoResponseDTO;
import org.gyl.crudgyl.entity.ProductoEntity.Producto;
import org.gyl.crudgyl.entity.TipoProductoEntity.TipoProducto;

public class ProductoMapper {
    private ProductoMapper(){}

    public static Producto toEntity(ProductoRequestDTO dto,TipoProducto tipoProducto){
        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
        producto.setId_tipo_producto(tipoProducto);
        return producto;
    }

    public static ProductoResponseDTO toResponseDTO(Producto producto){
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getId_tipo_producto().getId_tipo_producto(),
                producto.getId_tipo_producto().getNombre()
        );
    }

    public static void updateEntity(Producto producto, ProductoRequestDTO dto, TipoProducto tipoProducto ){
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
        producto.setId_tipo_producto(tipoProducto);
    }
}
