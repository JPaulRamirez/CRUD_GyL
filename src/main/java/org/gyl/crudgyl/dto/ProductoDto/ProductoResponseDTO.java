package org.gyl.crudgyl.dto.ProductoDto;

public record ProductoResponseDTO(
        long id,
        String nombre,
        Double precio,
        Integer stock,
        Long id_tipo_producto
) {
}
