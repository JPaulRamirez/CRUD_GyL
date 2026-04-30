package org.gyl.crudgyl.service.impl.Producto;

import org.gyl.crudgyl.dto.Producto.ProductoRequestDTO;
import org.gyl.crudgyl.dto.Producto.ProductoResponseDTO;
import org.gyl.crudgyl.entity.Producto.Producto;
import org.gyl.crudgyl.entity.TipoProducto.TipoProducto;
import org.gyl.crudgyl.exception.RecursoNoEncontradoException;
import org.gyl.crudgyl.mapper.ProductoMapper.ProductoMapper;
import org.gyl.crudgyl.repository.Producto.ProductoRepository;
import org.gyl.crudgyl.repository.TipoProducto.TipoProductoRepository;
import org.gyl.crudgyl.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final TipoProductoRepository tipoProductoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, TipoProductoRepository tipoProductoRepository){
        this.productoRepository = productoRepository;
        this.tipoProductoRepository = tipoProductoRepository;
    }

    @Override
    public ProductoResponseDTO crear(ProductoRequestDTO dto) {

        TipoProducto tipoProducto = tipoProductoRepository.findById(dto.id_tipo_producto())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                "No se encontró el id: " + dto.id_tipo_producto()
        ));

        Producto producto = ProductoMapper.toEntity(dto,tipoProducto);
        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toResponseDTO(guardado);
    }

    @Override
    public List<ProductoResponseDTO> listar() {
        return productoRepository.findAll()
                .stream()
                .map(ProductoMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProductoResponseDTO buscarPorID(Long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper::toResponseDTO)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id: " + id
                ));
    }

    @Override
    public ProductoResponseDTO actualizar(Long id, ProductoRequestDTO productoRequestDTO) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id" + id
                ));
        TipoProducto tipoProducto = tipoProductoRepository.findById(productoRequestDTO.id_tipo_producto())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id" + productoRequestDTO.id_tipo_producto()
                ));

        ProductoMapper.updateEntity(producto,productoRequestDTO,tipoProducto);
        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toResponseDTO(guardado);
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id" + id
                ));

        productoRepository.delete(producto);
    }

    @Override
    public List<ProductoResponseDTO> busquedaNombre(String nombre) {
        return productoRepository.findByNombre(nombre)
                .stream()
                .map(ProductoMapper::toResponseDTO)
                .toList();
    }
}
