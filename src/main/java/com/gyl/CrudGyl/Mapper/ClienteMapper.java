package com.gyl.CrudGyl.Mapper;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Entity.Cliente;
import com.gyl.CrudGyl.Entity.Producto;

public class ClienteMapper {
    public ClienteMapper() {
    }

    public static Cliente toEntity(ClienteRequestDto dto){
        Cliente cliente=new Cliente();

        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setCorreo(dto.correo());
        cliente.setTelefono(dto.telefono());
        cliente.setDireccion(dto.direccion());
        cliente.setEstadoCliente(dto.estado_cliente());

        return  cliente;
    }

    public static ClienteResponseDto toDto(Cliente cliente){

        return new ClienteResponseDto(
                cliente.getId_cliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCorreo(),
                cliente.getTelefono(),
                cliente.getDireccion(),
                cliente.getEstadoCliente()
        );
    }

    public static void updateEntity(Cliente cliente, ClienteRequestDto dto){
        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setDireccion(dto.direccion());
        cliente.setTelefono(dto.telefono());
        cliente.setCorreo(dto.correo());
        cliente.setEstadoCliente(dto.estado_cliente());
    }
    public static void updateEstado(Cliente cliente, ClienteRequestDto dto){
        cliente.setEstadoCliente(dto.estado_cliente());
    }

}
