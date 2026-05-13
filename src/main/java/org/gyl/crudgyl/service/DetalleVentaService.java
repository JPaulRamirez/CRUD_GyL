package org.gyl.crudgyl.service;

import org.gyl.crudgyl.dto.detalleVenta.DetalleVentaRequestDto;
import org.gyl.crudgyl.dto.detalleVenta.DetalleVentaResponseDto;

import java.util.List;

public interface DetalleVentaService {
    DetalleVentaResponseDto crear(DetalleVentaRequestDto dto);

    List<DetalleVentaResponseDto> listar();

    DetalleVentaResponseDto buscarPorId(Long id);

}
