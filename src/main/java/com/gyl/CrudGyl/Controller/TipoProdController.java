package com.gyl.CrudGyl.Controller;

import com.gyl.CrudGyl.Dto.Request.TipoProdRequestDto;
import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.TipoProdResponseDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Entity.TipoProducto;
import com.gyl.CrudGyl.Services.TipoProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tipoProd")
public class TipoProdController {
    private final TipoProductoService tipoProductoService;

    public TipoProdController(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoProdResponseDto crear(@Valid @RequestBody TipoProdRequestDto requestdTO){
        return tipoProductoService.crear(requestdTO);
    }
    @GetMapping
    public List<TipoProdResponseDto> listar(){
        return tipoProductoService.listarTipoProducto();
    }

    @GetMapping("/estado")
    public List<TipoProdResponseDto> listarEstados(){
        return tipoProductoService.listarClientesConEstadoTrue();
    }

    @PutMapping("/estado/{id}")//eliminar sin tener que usar delete
    public TipoProdResponseDto cambiarEstado(@PathVariable Long id, @Valid @RequestBody TipoProdRequestDto dto){
        return tipoProductoService.actualizarEstado(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        tipoProductoService.eliminar(id);
    }
    @GetMapping("/{id}")
    public TipoProdResponseDto buscarPorId(@PathVariable Long id){
        return tipoProductoService.buscarPorId(id);
    }

//    @GetMapping("/buscar/{nombre}")
//    public List<VentaResponseDto> buscarPorFecha(@PathVariable LocalDate fecha){
//        return ventaService.busquedaNombre(nombre);
//    }

    //@PatchMapping
    @PutMapping("/{id}")
    public TipoProdResponseDto actualizarProducto(@PathVariable Long id, @Valid @RequestBody TipoProdRequestDto dto) {
        return tipoProductoService.actualizar(id, dto);
    }
}
