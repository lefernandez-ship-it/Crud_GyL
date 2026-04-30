package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Entity.Venta;
import com.gyl.CrudGyl.Exceptions.RecursosNoEncontradoException;
import com.gyl.CrudGyl.Mapper.VentaMapper;
import com.gyl.CrudGyl.Repository.VentaRepository;
import com.gyl.CrudGyl.Services.Interfaces.IVentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    private VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public VentaResponseDto crear(VentaRequestDto dto) {
        Venta venta= VentaMapper.toEntity(dto);
        Venta guardado=ventaRepository.save(venta);
        return VentaMapper.toDto(guardado);
    }

    @Override
    public List<VentaResponseDto> listarProductos() {

        return ventaRepository.findAll()
                .stream()
                .map(VentaMapper::toDto)
                .toList();
    }

    @Override
    public VentaResponseDto buscarPorId(Long id) {

        return ventaRepository.findById(id)
                .map(VentaMapper::toDto)
                .orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro el id: "+id
        ));
    }

    @Override
    public VentaResponseDto actualizar(Long id, VentaRequestDto dto) {
        Venta venta=ventaRepository.findById(id).orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro la venta con el id: "+id
        ));
        VentaMapper.updateEstado(venta,dto);
        Venta guardado=ventaRepository.save(venta);
        return VentaMapper.toDto(guardado);
    }

    @Override
    public void eliminar(Long id) {
        Venta venta=ventaRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro la venta con el id: "+id
        ));

        ventaRepository.delete(venta);
    }

    @Override
    public List<VentaResponseDto> listarClientesConEstadoTrue() {

        return ventaRepository.findByEstadoVentaTrue()
                .stream()
                .map(VentaMapper::toDto)
                .toList();
    }

    @Override
    public VentaResponseDto actualizarEstado(Long id, VentaRequestDto dto) {
        Venta venta=ventaRepository.findById(id).orElseThrow(()-> new RecursosNoEncontradoException(
                "No se encontro una venta con el id: "+id
        ));

        return null;
    }
}
