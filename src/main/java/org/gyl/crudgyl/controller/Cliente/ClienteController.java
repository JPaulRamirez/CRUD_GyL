package org.gyl.crudgyl.controller.Cliente;

import jakarta.validation.Valid;
import org.gyl.crudgyl.dto.Cliente.ClienteRequestDto;
import org.gyl.crudgyl.dto.Cliente.ClienteResponseDto;
import org.gyl.crudgyl.dto.TipoProducto.TipoProductoResponseDTO;
import org.gyl.crudgyl.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService)
    {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto crear(@Valid @RequestBody ClienteRequestDto clienteRequestDto)
    {
        return clienteService.crear(clienteRequestDto);
    }
    @GetMapping
    public List<ClienteResponseDto> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteResponseDto buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody ClienteRequestDto clienteRequestDto) {
        return clienteService.actualizar(id, clienteRequestDto);
    }
}
