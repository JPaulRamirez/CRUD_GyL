package org.gyl.crudgyl.service.impl.DetalleVenta;

import org.gyl.crudgyl.dto.detalleVenta.DetalleVentaRequestDto;
import org.gyl.crudgyl.dto.detalleVenta.DetalleVentaResponseDto;
import org.gyl.crudgyl.entity.DetalleVenta.DetalleVenta;
import org.gyl.crudgyl.entity.Producto.Producto;
import org.gyl.crudgyl.entity.Venta.Venta;
import org.gyl.crudgyl.exception.RecursoNoEncontradoException;
import org.gyl.crudgyl.mapper.DetalleVenta.DetalleVentaMapper;
import org.gyl.crudgyl.repository.detalleVenta.DetalleVentaRepository;
import org.gyl.crudgyl.repository.producto.ProductoRepository;
import org.gyl.crudgyl.repository.Venta.VentaRepository;
import org.gyl.crudgyl.service.DetalleVentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;
    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;

    public DetalleVentaServiceImpl( DetalleVentaRepository detalleVentaRepository, VentaRepository ventaRepository, ProductoRepository productoRepository)
    {
        this.detalleVentaRepository = detalleVentaRepository;
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
    }
    @Override
    public DetalleVentaResponseDto crear(DetalleVentaRequestDto dto) {
        Venta venta = ventaRepository.findById(dto.id_venta())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró la venta con id: " + dto.id_venta()
                ));

        Producto producto = productoRepository.findById(dto.id_producto())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el producto con id: " + dto.id_producto()
                ));

        DetalleVenta detalleVenta = DetalleVentaMapper.toEntity(dto, venta, producto);
        DetalleVenta guardado = detalleVentaRepository.save(detalleVenta);

        venta.setTotal(venta.getTotal() + guardado.getSubtotal());
        ventaRepository.save(venta);

        return DetalleVentaMapper.toResponseDto(guardado);
    }

    @Override
    public List<DetalleVentaResponseDto> listar() {
        return detalleVentaRepository.findAll()
                .stream()
                .map(DetalleVentaMapper::toResponseDto)
                .toList();
    }

    @Override
    public DetalleVentaResponseDto buscarPorId(Long id) {
        return detalleVentaRepository.findById(id)
                .map(DetalleVentaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el detalle de venta con id: " + id
                ));
    }
}
