package org.gyl.crudgyl.controller.DetalleVenta;

import jakarta.validation.Valid;
import org.gyl.crudgyl.dto.detalleVenta.DetalleVentaRequestDto;
import org.gyl.crudgyl.dto.detalleVenta.DetalleVentaResponseDto;
import org.gyl.crudgyl.service.DetalleVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-ventas")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleVentaResponseDto crear(@Valid @RequestBody DetalleVentaRequestDto dto) {
        return detalleVentaService.crear(dto);
    }

    @GetMapping
    public List<DetalleVentaResponseDto> listar() {
        return detalleVentaService.listar();
    }

    @GetMapping("/{id}")
    public DetalleVentaResponseDto buscarPorId(@PathVariable Long id) {
        return detalleVentaService.buscarPorId(id);
    }
}
