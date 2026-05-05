package com.gyl.CrudGyl.Services.Interfaces;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Request.DetalleVentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Dto.Response.DetalleVentaResponseDto;
import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;

import java.util.List;

public interface IDetalleVentaService {

    DetalleVentaResponseDto crear(DetalleVentaRequestDto dto);

    List<DetalleVentaResponseDto> listarDetalleVentas();

    DetalleVentaResponseDto buscarPorId(Long id);

    DetalleVentaResponseDto actualizar(Long id,DetalleVentaRequestDto dto);

    void eliminar(Long id);

    List<DetalleVentaResponseDto> listarDetallesConEstadoTrue();
    List<DetalleVentaResponseDto> listarDetallesConEstadoFalse();

    DetalleVentaResponseDto actualizarEstado(Long id, DetalleVentaRequestDto dto);
}
