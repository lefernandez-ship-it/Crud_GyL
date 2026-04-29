package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.DetalleVentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.DetalleVentaResponseDto;
import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Repository.DetalleVentaRepository;
import com.gyl.CrudGyl.Services.Interfaces.IDetalleVentaService;

import java.util.List;

public class DetalleVentaService implements IDetalleVentaService {
    private DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {this.detalleVentaRepository = detalleVentaRepository;}

    @Override
    public DetalleVentaResponseDto crear(DetalleVentaRequestDto dto) {
        return null;
    }

    @Override
    public List<DetalleVentaResponseDto> listarDetalleVentas() {
        return List.of();
    }

    @Override
    public VentaResponseDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public VentaResponseDto actualizar(Long id, VentaRequestDto dto) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
