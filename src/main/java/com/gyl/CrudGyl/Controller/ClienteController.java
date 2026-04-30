package com.gyl.CrudGyl.Controller;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;
import com.gyl.CrudGyl.Services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    private  final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto crear(@Valid @RequestBody ClienteRequestDto requestdTO){
        return clienteService.crear(requestdTO);
    }
    @GetMapping
    public List<ClienteResponseDto> listar(){
        return clienteService.listarCliente();
    }

    @GetMapping("/estado")
    public List<ClienteResponseDto> listarEstados(){
        return clienteService.listarClientesConEstadoTrue();
    }

    @PutMapping("/estado/{id}")//eliminar sin tener que usar delete
    public ClienteResponseDto cambiarEstado(@PathVariable Long id, @Valid @RequestBody ClienteRequestDto dto){
        return clienteService.actualizarEstado(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        clienteService.eliminar(id);
    }
    @GetMapping("/{id}")
    public ClienteResponseDto buscarPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @GetMapping("/buscar/{nombre}")
    public List<ClienteResponseDto> buscarPorNombre(@PathVariable String nombre){
        return clienteService.busquedaNombre(nombre);
    }

    //@PatchMapping
    @PutMapping("/{id}")
    public ClienteResponseDto actualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteRequestDto dto) {
        return clienteService.actualizar(id, dto);
    }
}
