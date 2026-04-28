package org.gyl.crudgyl.service;


import org.gyl.crudgyl.dto.TipoProductoDto.TipoProductoRequestDTO;
import org.gyl.crudgyl.dto.TipoProductoDto.TipoProductoResponseDTO;

import java.util.List;

public interface TIpoProductoService {

    TipoProductoResponseDTO crear(TipoProductoRequestDTO tipoProductoRequestDTO);

    List<TipoProductoResponseDTO> listar();

    TipoProductoResponseDTO buscarPorId(Long id);

    TipoProductoResponseDTO actualizar(Long id , TipoProductoRequestDTO dto);

    void eliminar(Long id);

}
