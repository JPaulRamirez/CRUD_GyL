package org.gyl.crudgyl.controller;

import jakarta.validation.Valid;
import org.gyl.crudgyl.dto.ProductoDto.ProductoRequestDTO;
import org.gyl.crudgyl.dto.ProductoDto.ProductoResponseDTO;
import org.gyl.crudgyl.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")

public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService)
    {
        this.productoService = productoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponseDTO crear(@Valid @RequestBody ProductoRequestDTO dto){
        return productoService.crear(dto);

    }

    @GetMapping
    public List<ProductoResponseDTO> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO buscarPorIdDto(@PathVariable Long id)
    {
        return productoService.buscarPorID(id);
    }
    @PutMapping("/{id}")
    public ProductoResponseDTO actualizar(@PathVariable Long id,@RequestBody ProductoRequestDTO dto)
    {
        return productoService.actualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id)
    {
        productoService.eliminar(id);
    }
    @GetMapping("/buscar/{nombre}")
    public List<ProductoResponseDTO> busquedaNombre(@PathVariable String nombre) {
        return productoService.busquedaNombre(nombre);
    }

}
