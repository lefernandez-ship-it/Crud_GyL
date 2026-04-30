package com.gyl.CrudGyl.Controller;

import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Services.VentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/venta")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaResponseDto crear(@Valid @RequestBody VentaRequestDto requestdTO){
        return ventaService.crear(requestdTO);
    }
    @GetMapping
    public List<VentaResponseDto> listar(){
        return ventaService.listarVentas();
    }

    @GetMapping("/estado")
    public List<VentaResponseDto> listarEstados(){
        return ventaService.listarVentasConEstadoTrue();
    }

    @PutMapping("/estado/{id}")//eliminar sin tener que usar delete
    public VentaResponseDto cambiarEstado(@PathVariable Long id, @Valid @RequestBody VentaRequestDto dto){
        return ventaService.actualizarEstado(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        ventaService.eliminar(id);
    }
    @GetMapping("/{id}")
    public VentaResponseDto buscarPorId(@PathVariable Long id){
        return ventaService.buscarPorId(id);
    }

//    @GetMapping("/buscar/{nombre}")
//    public List<VentaResponseDto> buscarPorFecha(@PathVariable LocalDate fecha){
//        return ventaService.busquedaNombre(nombre);
//    }

    //@PatchMapping
    @PutMapping("/{id}")
    public VentaResponseDto actualizarProducto(@PathVariable Long id, @Valid @RequestBody VentaRequestDto dto) {
        return ventaService.actualizar(id, dto);
    }
}
