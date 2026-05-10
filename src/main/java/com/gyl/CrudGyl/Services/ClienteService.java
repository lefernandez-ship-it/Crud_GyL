package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Entity.Cliente;
import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Entity.TipoProducto;
import com.gyl.CrudGyl.Exceptions.RecursosNoEncontradoException;
import com.gyl.CrudGyl.Mapper.ClienteMapper;
import com.gyl.CrudGyl.Mapper.ProductoMapper;
import com.gyl.CrudGyl.Repository.ClienteRepository;
import com.gyl.CrudGyl.Services.Interfaces.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {this.clienteRepository = clienteRepository;}

    @Override
    public ClienteResponseDto crear(ClienteRequestDto dto) {
        Cliente cliente= ClienteMapper.toEntity(dto);
        Cliente  guardado=clienteRepository.save(cliente);
        return ClienteMapper.toDto(guardado);//toResponseDt
    }

    @Override
    public List<ClienteResponseDto> listarCliente() {
        return clienteRepository.findAll().stream()
                .map(ClienteMapper::toDto)
                .toList();
    }

    @Override
    public ClienteResponseDto buscarPorId(Long id) {
        return clienteRepository.findById(id).
                map(ClienteMapper:: toDto).
                orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+id));
    }

    @Override
    public ClienteResponseDto actualizar(Long id, ClienteRequestDto dto) {
        Cliente cliente=clienteRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+ id
                ));
        ClienteMapper.updateEntity(cliente,dto);
        Cliente guardado=clienteRepository.save(cliente);
        return ClienteMapper.toDto(guardado);
    }

    @Override
    public ClienteResponseDto eliminar(Long id) {
        Cliente cliente=clienteRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+ id
                ));
        clienteRepository.delete(cliente);
        System.out.println("Se elimino el cliente con el id: "+cliente.getId_cliente());
        return  ClienteMapper.toDto(cliente);
    }

    @Override
    public List<ClienteResponseDto> busquedaNombre(String nombre) {
        List<Cliente> clientes = clienteRepository.findByNombre(nombre);

        return Optional.ofNullable(clienteRepository.findByNombre(nombre))
                .filter(lista -> !lista.isEmpty())
                .map(lista -> lista.stream()
                        .map(ClienteMapper::toDto)
                        .toList())
                .orElseThrow(() -> new RecursosNoEncontradoException("No se encontraron clientes con el nombre: " + nombre));
    }

    //FALTA ESTO
    @Override
    public List<ClienteResponseDto> listarClientesConEstadoTrue() {
        return clienteRepository.findByEstadoClienteTrue()
                .stream()
                .map(ClienteMapper::toDto)
                .toList();
    }

    @Override
    public List<ClienteResponseDto> listarClientesConEstadoFalse() {
        return clienteRepository.findByEstadoClienteFalse()
                .stream()
                .map(ClienteMapper::toDto)
                .toList();
    }

    /**
     *
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public ClienteResponseDto actualizarEstado(Long id, ClienteRequestDto dto) {
        Cliente cliente=clienteRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+id
                ));

        ClienteMapper.updateEstado(cliente,dto);
        Cliente guardado=clienteRepository.save(cliente);
        return ClienteMapper.toDto(guardado);
    }
}
