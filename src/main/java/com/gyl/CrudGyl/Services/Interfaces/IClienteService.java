package com.gyl.CrudGyl.Services.Interfaces;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;

import java.util.List;

public interface IClienteService {

    ClienteResponseDto crear(ClienteRequestDto dto);

    List<ClienteResponseDto> listarCliente();

    ClienteResponseDto buscarPorId(Long id);

    ClienteResponseDto actualizar(Long id,ClienteRequestDto dto);

    void eliminar(Long id);

    List<ClienteResponseDto> busquedaNombre(String nombre);

    List<ClienteResponseDto> listarClientesConEstadoTrue();

    ClienteResponseDto actualizarEstado(Long id,ClienteRequestDto dto);




}
