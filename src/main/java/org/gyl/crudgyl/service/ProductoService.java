package org.gyl.crudgyl.service;

import org.gyl.crudgyl.dto.ProductoDto.ProductoRequestDTO;
import org.gyl.crudgyl.dto.ProductoDto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {

    ProductoResponseDTO crear(ProductoRequestDTO producto);

    List<ProductoResponseDTO> listar();

    ProductoResponseDTO buscarPorID(Long id);

    ProductoResponseDTO actualizar(Long id , ProductoRequestDTO dto);
    void eliminar(Long id);

    List<ProductoResponseDTO> busquedaNombre(String nombre);
}
