package org.gyl.crudgyl.dto;

import jakarta.validation.constraints.NotBlank;

public record TipoProductoRequestDTO(
        @NotBlank(message = "El nombre no puede ser vacio")
        String nombre,
        String descripcion
) {
}
