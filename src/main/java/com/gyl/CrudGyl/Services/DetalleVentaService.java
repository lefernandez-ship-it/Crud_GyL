package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.DetalleVentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.DetalleVentaResponseDto;
import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Entity.DetalleVenta;
import com.gyl.CrudGyl.Entity.TipoProducto;
import com.gyl.CrudGyl.Exceptions.RecursosNoEncontradoException;
import com.gyl.CrudGyl.Mapper.DetalleVentaMapper;
import com.gyl.CrudGyl.Mapper.TipoProdMapper;
import com.gyl.CrudGyl.Repository.DetalleVentaRepository;
import com.gyl.CrudGyl.Services.Interfaces.IDetalleVentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService implements IDetalleVentaService {
    private DetalleVentaRepository detalleVentaRepository;



    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {this.detalleVentaRepository = detalleVentaRepository;}

    @Override
    public DetalleVentaResponseDto crear(DetalleVentaRequestDto dto) {
        return null;
    }

    @Override
    public List<DetalleVentaResponseDto> listarDetalleVentas() {

        return detalleVentaRepository.findByEstadoDetalleVentaTrue()
                .stream()
                .map(DetalleVentaMapper::toDto)
                .toList();
    }

    @Override
    public DetalleVentaResponseDto buscarPorId(Long id) {

        return detalleVentaRepository.findById(id)
                .map(DetalleVentaMapper::toDto)
                .orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro un detalle de venta con el id: "+id
        ));
    }

    @Override
    public DetalleVentaResponseDto actualizar(Long id, DetalleVentaRequestDto dto) {
        DetalleVenta detalleVenta=detalleVentaRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException("" +
                "No se encontro un detalle de venta con el id: "+id));


        DetalleVentaMapper.updateEntity(detalleVenta,dto);
        DetalleVenta guardado=detalleVentaRepository.save(detalleVenta);
        return DetalleVentaMapper.toDto(guardado);
    }

    @Override
    public void eliminar(Long id) {

        DetalleVenta detalleVenta=detalleVentaRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException("" +
                "No se encontro un detalle venta con ese id: "+id));

        detalleVentaRepository.delete(detalleVenta);
    }

    @Override
    public List<DetalleVentaResponseDto> listarDetallesConEstadoTrue() {

        return detalleVentaRepository.findByEstadoDetalleVentaTrue() // Sin el punto y coma aquí
                .stream()
                .map(DetalleVentaMapper::toDto)
                .toList();
    }

    @Override
    public List<DetalleVentaResponseDto> listarDetallesConEstadoFalse() {
        return detalleVentaRepository.findByEstadoDetalleVentaFalse() // Sin el punto y coma aquí
                .stream()
                .map(DetalleVentaMapper::toDto)
                .toList();
    }

    @Override
    public DetalleVentaResponseDto actualizarEstado(Long id, DetalleVentaRequestDto dto) {

        DetalleVenta detalleVenta=detalleVentaRepository.findById(id).orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro un detalle de venta con el id: "+id
        ));

        DetalleVentaMapper.updateEstado(detalleVenta,dto);
        DetalleVenta guardado=detalleVentaRepository.save(detalleVenta);

        return DetalleVentaMapper.toDto(guardado);
    }
}
