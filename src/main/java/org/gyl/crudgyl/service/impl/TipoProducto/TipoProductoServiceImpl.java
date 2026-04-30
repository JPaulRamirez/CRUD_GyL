package org.gyl.crudgyl.service.impl.TipoProducto;

import org.gyl.crudgyl.dto.TipoProducto.TipoProductoRequestDTO;
import org.gyl.crudgyl.dto.TipoProducto.TipoProductoResponseDTO;
import org.gyl.crudgyl.entity.TipoProducto.TipoProducto;
import org.gyl.crudgyl.exception.RecursoNoEncontradoException;
import org.gyl.crudgyl.mapper.TipoProducto.TipoProductoMapper;
import org.gyl.crudgyl.repository.TipoProducto.TipoProductoRepository;
import org.gyl.crudgyl.service.TIpoProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TIpoProductoService {

    private TipoProductoRepository tipoProductoRepository;

    public TipoProductoServiceImpl(TipoProductoRepository tipoProductoRepository)
    {
        this.tipoProductoRepository = tipoProductoRepository;
    }


    @Override
    public TipoProductoResponseDTO crear(TipoProductoRequestDTO tipoProductoRequestDTO) {

        TipoProducto tipoProducto = TipoProductoMapper.toEntity(tipoProductoRequestDTO);
        TipoProducto guardado = tipoProductoRepository.save(tipoProducto);
        return TipoProductoMapper.toResponseDTO(guardado);
    }

    @Override
    public List<TipoProductoResponseDTO> listar() {
        return tipoProductoRepository.findAll().stream()
                .map(TipoProductoMapper::toResponseDTO)
                .toList();
    }

    @Override
    public TipoProductoResponseDTO buscarPorId(Long id) {
        return tipoProductoRepository.findById(id)
                .map(TipoProductoMapper::toResponseDTO)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id: " + id
                ));
    }

    @Override
    public TipoProductoResponseDTO actualizar(Long id, TipoProductoRequestDTO dto) {
        TipoProducto tipoProducto = tipoProductoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id: " + id
                ));

        TipoProductoMapper.updateEntity(tipoProducto,dto);
        TipoProducto guardado = tipoProductoRepository.save(tipoProducto);
        return TipoProductoMapper.toResponseDTO(guardado);
    }

    @Override
    public void eliminar(Long id) {
        TipoProducto tipoProducto = tipoProductoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id: " + id
                ));
        tipoProductoRepository.delete(tipoProducto);
    }
}
