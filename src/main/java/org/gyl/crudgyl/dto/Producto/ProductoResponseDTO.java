package org.gyl.crudgyl.dto.Producto;

public record ProductoResponseDTO(
        long id,
        String nombre,
        Double precio,
        Integer stock,
        Long id_tipo_producto,
        String nombre_tipo_producto
) {
}
