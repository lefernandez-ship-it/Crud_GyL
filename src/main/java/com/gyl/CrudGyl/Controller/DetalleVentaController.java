package com.gyl.CrudGyl.Controller;

import com.gyl.CrudGyl.Dto.Request.ClienteRequestDto;
import com.gyl.CrudGyl.Dto.Request.DetalleVentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.ClienteResponseDto;
import com.gyl.CrudGyl.Dto.Response.DetalleVentaResponseDto;
import com.gyl.CrudGyl.Services.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detalleVenta")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleVentaResponseDto crear(@Valid @RequestBody DetalleVentaRequestDto requestdTO){
        return detalleVentaService.crear(requestdTO);
    }
    @GetMapping
    public List<DetalleVentaResponseDto> listar(){
        return detalleVentaService.listarDetalleVentas();
    }

    @GetMapping("/estado")
    public List<DetalleVentaResponseDto> listarEstados(){
        return detalleVentaService.listarDetallesConEstadoTrue();
    }

    @PutMapping("/estado/{id}")//eliminar sin tener que usar delete
    public DetalleVentaResponseDto cambiarEstado(@PathVariable Long id, @Valid @RequestBody DetalleVentaRequestDto dto){
        return detalleVentaService.actualizarEstado(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        detalleVentaService.eliminar(id);
    }

    @GetMapping("/{id}")
    public DetalleVentaResponseDto buscarPorId(@PathVariable Long id){
        return detalleVentaService.buscarPorId(id);
    }

//    @GetMapping("/buscar/{nombre}")
//    public List<ClienteResponseDto> buscarPorNombre(@PathVariable String nombre){
//        return clienteService.busquedaNombre(nombre);
//    }

    //@PatchMapping
//    @PutMapping("/{id}")
//    public DetalleVentaResponseDto actualizarDetalleVenta(@PathVariable Long id, @Valid @RequestBody DetalleVentaRequestDto dto) {
//        return detalleVentaService.actualizar(id, dto);
//    }
}
