package org.gyl.crudgyl.controller.TipoProducto;

import jakarta.validation.Valid;
import org.gyl.crudgyl.dto.TipoProducto.TipoProductoRequestDTO;
import org.gyl.crudgyl.dto.TipoProducto.TipoProductoResponseDTO;
import org.gyl.crudgyl.service.impl.TipoProducto.TipoProductoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tipoProductos")
public class TipoProductoController {

    private final TipoProductoServiceImpl tipoProductoService;


    public TipoProductoController(TipoProductoServiceImpl tipoProductoService){
        this.tipoProductoService = tipoProductoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoProductoResponseDTO crear(@Valid @RequestBody TipoProductoRequestDTO requestDTO)
    {
        return tipoProductoService.crear(requestDTO);
    }
    @GetMapping
    public List<TipoProductoResponseDTO> listar() {
        return tipoProductoService.listar();
    }

    @GetMapping("/{id}")
    public TipoProductoResponseDTO buscarPorIdDto(@PathVariable Long id)
    {
        return tipoProductoService.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public TipoProductoResponseDTO actualizar(@PathVariable Long id,@RequestBody TipoProductoRequestDTO dto)
    {
        return tipoProductoService.actualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id)
    {
        tipoProductoService.eliminar(id);
    }
}

