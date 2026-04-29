package org.gyl.crudgyl.dto.Cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDto(
        @NotBlank(message = "El nombre no peude estar vacio")
        String nombre,
        @NotBlank(message = "El apellido no peude estar vacio")
        String apellido,
        @NotBlank(message = "El correo no peude estar vacio")
        String correo,
        @NotBlank(message = "El telefono no peude estar vacio")
        String telefono,
        @NotBlank(message = "El direccion no peude estar vacio")
        String direccion

) {

}
