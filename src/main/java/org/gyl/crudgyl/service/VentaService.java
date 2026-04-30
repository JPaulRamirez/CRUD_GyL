package org.gyl.crudgyl.service;

import org.gyl.crudgyl.dto.Venta.VentaRequestDto;
import org.gyl.crudgyl.dto.Venta.VentaResponseDto;

import java.util.List;

public interface VentaService {

    VentaResponseDto crear(VentaRequestDto dto);

    List<VentaResponseDto> listar();

    VentaResponseDto buscarPorId(Long id);
}
