package com.gyl.CrudGyl.Services.Interfaces;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;

import java.util.List;

public interface IVentaService {

    VentaResponseDto crear(VentaRequestDto dto);

    List<VentaResponseDto> listarVentas();

    VentaResponseDto buscarPorId(Long id);

    VentaResponseDto actualizar(Long id,VentaRequestDto dto);

    void eliminar(Long id);

    List<VentaResponseDto> listarVentasConEstadoTrue();
    List<VentaResponseDto> listarVentasConEstadoFalse();
    VentaResponseDto actualizarEstado(Long id, VentaRequestDto dto);
}
