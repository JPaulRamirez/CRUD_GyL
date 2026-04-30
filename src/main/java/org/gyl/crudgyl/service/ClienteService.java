package org.gyl.crudgyl.service;

import org.gyl.crudgyl.dto.Cliente.ClienteRequestDto;
import org.gyl.crudgyl.dto.Cliente.ClienteResponseDto;

public interface ClienteService {
    ClienteResponseDto crear(ClienteRequestDto dto);
}
