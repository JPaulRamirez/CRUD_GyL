package org.gyl.crudgyl.service.impl.Cliente;

import org.gyl.crudgyl.dto.Cliente.ClienteRequestDto;
import org.gyl.crudgyl.dto.Cliente.ClienteResponseDto;

import org.gyl.crudgyl.entity.Cliente.Cliente;
import org.gyl.crudgyl.mapper.Cliente.ClienteMapper;
import org.gyl.crudgyl.repository.Cliente.ClienteRepository;
import org.gyl.crudgyl.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;


    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }



    @Override
    public ClienteResponseDto crear(ClienteRequestDto dto) {
        Cliente cliente = ClienteMapper.ToEntity(dto);
        Cliente guardado = clienteRepository.save(cliente);
        return ClienteMapper.toResponseDto(guardado);
    }
}
