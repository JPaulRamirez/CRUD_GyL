package org.gyl.crudgyl.controller.Venta;

import jakarta.validation.Valid;
import org.gyl.crudgyl.dto.Venta.VentaRequestDto;
import org.gyl.crudgyl.dto.Venta.VentaResponseDto;
import org.gyl.crudgyl.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaResponseDto crear(@Valid @RequestBody VentaRequestDto dto) {
        return ventaService.crear(dto);
    }

    @GetMapping
    public List<VentaResponseDto> listar() {
        return ventaService.listar();
    }

    @GetMapping("/{id}")
    public VentaResponseDto buscarPorId(@PathVariable Long id) {
        return ventaService.buscarPorId(id);
    }
}
