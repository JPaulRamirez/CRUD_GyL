package org.gyl.crudgyl.dto.Cliente;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteRequestDto(
        @NotBlank(message = "El nombre no peude estar vacio")
        String nombre,
        @NotBlank(message = "El apellido no peude estar vacio")
        String apellido,
        @Email(message = "El correo tiene que ser valido")
        @Column(unique = true)
        String correo,
        @Pattern(regexp = "^\\d{8}$")
        String telefono,
        @NotBlank(message = "El direccion no peude estar vacio")
        String direccion

) {

}
