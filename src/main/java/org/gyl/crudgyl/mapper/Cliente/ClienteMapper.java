package org.gyl.crudgyl.mapper.Cliente;

import org.gyl.crudgyl.dto.Cliente.ClienteRequestDto;
import org.gyl.crudgyl.dto.Cliente.ClienteResponseDto;
import org.gyl.crudgyl.entity.Cliente.Cliente;

public class ClienteMapper {
    private ClienteMapper()
    {

    }

    public static Cliente ToEntity(ClienteRequestDto clienteRequestDto)
    {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteRequestDto.nombre());
        cliente.setApellido(clienteRequestDto.apellido());
        cliente.setCorreo(clienteRequestDto.correo());
        cliente.setTelefono(clienteRequestDto.telefono());
        cliente.setDireccion(clienteRequestDto.direccion());
        return cliente;
    }

    public static ClienteResponseDto toResponseDto(Cliente cliente)
    {
        return new ClienteResponseDto(
                cliente.getId_cliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCorreo(),
                cliente.getTelefono(),
                cliente.getDireccion()
        );
    }

    public static void updateEntity(Cliente cliente, ClienteRequestDto clienteRequestDto)
    {
        cliente.setNombre(clienteRequestDto.nombre());
        cliente.setApellido(clienteRequestDto.apellido());
        cliente.setCorreo(clienteRequestDto.correo());
        cliente.setTelefono(clienteRequestDto.telefono());
        cliente.setDireccion(clienteRequestDto.direccion());
    }
}
