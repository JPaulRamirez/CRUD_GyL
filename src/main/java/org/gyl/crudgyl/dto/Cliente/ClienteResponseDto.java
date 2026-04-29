package org.gyl.crudgyl.dto.Cliente;

public record ClienteResponseDto(
        Long id_cliente,
        String nombre,
        String apellido,
        String correo,
        String telefono,
        String direccion


) {

}
