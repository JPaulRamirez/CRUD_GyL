package org.gyl.crudgyl.controller.Cliente;

import jakarta.validation.Valid;
import org.gyl.crudgyl.dto.Cliente.ClienteRequestDto;
import org.gyl.crudgyl.dto.Cliente.ClienteResponseDto;
import org.gyl.crudgyl.service.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService)
    {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteResponseDto crear(@Valid @RequestBody ClienteRequestDto clienteRequestDto)
    {
        return clienteService.crear(clienteRequestDto);
    }
}
