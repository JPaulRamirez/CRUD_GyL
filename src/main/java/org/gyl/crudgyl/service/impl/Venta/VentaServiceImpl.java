package org.gyl.crudgyl.service.impl.Venta;

import org.gyl.crudgyl.dto.Venta.VentaRequestDto;
import org.gyl.crudgyl.dto.Venta.VentaResponseDto;
import org.gyl.crudgyl.entity.Cliente.Cliente;
import org.gyl.crudgyl.entity.Venta.Venta;
import org.gyl.crudgyl.exception.RecursoNoEncontradoException;
import org.gyl.crudgyl.mapper.Ventas.VentaMapper;
import org.gyl.crudgyl.repository.Cliente.ClienteRepository;
import org.gyl.crudgyl.repository.Venta.VentaRepository;
import org.gyl.crudgyl.service.VentaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VentaServiceImpl implements VentaService {
    private final VentaRepository ventaRepository;
    private final ClienteRepository clienteRepository;

    public VentaServiceImpl(VentaRepository ventaRepository, ClienteRepository clienteRepository) {
        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
    }


    @Override
    public VentaResponseDto crear(VentaRequestDto dto) {
        Cliente cliente = clienteRepository.findById(dto.id_cliente())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el cliente con id: " + dto.id_cliente()
                ));

        Venta venta = VentaMapper.toEntity(dto, cliente);
        Venta guardado = ventaRepository.save(venta);
        return  VentaMapper.toResponseDto(guardado);
    }

    @Override
    public List<VentaResponseDto> listar() {
        return ventaRepository.findAll()
                .stream()
                .map(VentaMapper::toResponseDto)
                .toList();
    }

    @Override
    public VentaResponseDto buscarPorId(Long id) {
        return ventaRepository.findById(id)
                .map(VentaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró la venta con id: " + id
                ));
    }
}
