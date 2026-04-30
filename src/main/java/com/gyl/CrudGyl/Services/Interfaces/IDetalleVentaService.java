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

    VentaResponseDto buscarPorId(Long id);

    VentaResponseDto actualizar(Long id,VentaRequestDto dto);

    void eliminar(Long id);

    List<DetalleVentaResponseDto> listarDetallesConEstadoTrue();

    DetalleVentaResponseDto actualizarEstado(Long id, DetalleVentaRequestDto dto);
}
