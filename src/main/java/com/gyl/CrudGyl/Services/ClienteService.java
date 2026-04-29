package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Repository.ClienteRepository;
import com.gyl.CrudGyl.Services.Interfaces.IClienteService;

import java.util.List;

public class ClienteService implements IClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {this.clienteRepository = clienteRepository;}

    @Override
    public ClienteResponseDto crear(ClienteRequestDto dto) {
        return null;
    }

    @Override
    public List<ClienteResponseDto> listarCliente() {
        return List.of();
    }

    @Override
    public ClienteResponseDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public ClienteResponseDto actualizar(Long id, ClienteRequestDto dto) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<ClienteResponseDto> busquedaNombre(String nombre) {
        return List.of();
    }
}
