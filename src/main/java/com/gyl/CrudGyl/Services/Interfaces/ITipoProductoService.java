package com.gyl.CrudGyl.Services.Interfaces;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Request.TipoProdRequestDto;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Dto.Response.TipoProdResponseDto;

import java.util.List;

public interface ITipoProductoService {
    TipoProdResponseDto crear(TipoProdRequestDto dto);

    List<TipoProdResponseDto> listarTipoProducto();

    TipoProdResponseDto buscarPorId(Long id);

    TipoProdResponseDto actualizar(Long id,TipoProdRequestDto dto);

    void eliminar(Long id);

    List<TipoProdResponseDto> busquedaNombre(String nombre);

    List<TipoProdResponseDto> listarClientesConEstadoTrue();
    List<TipoProdResponseDto> listarClientesConEstadoFalse();

    TipoProdResponseDto actualizarEstado(Long id, TipoProdRequestDto dto);
}
