package org.gyl.crudgyl.service;

import org.gyl.crudgyl.dto.Cliente.ClienteRequestDto;
import org.gyl.crudgyl.dto.Cliente.ClienteResponseDto;
import org.gyl.crudgyl.dto.DetalleVenta.DetalleVentaResponseDto;

import java.util.List;

public interface ClienteService {
    ClienteResponseDto crear(ClienteRequestDto dto);

    List<ClienteResponseDto> listar();

    ClienteResponseDto buscarPorId(Long id);
}
