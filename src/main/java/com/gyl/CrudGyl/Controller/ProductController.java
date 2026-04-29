package com.gyl.CrudGyl.Controller;

import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;
import com.gyl.CrudGyl.Services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductController {
    private final ProductoService productoService;

    public ProductController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponsetDto crear(@Valid @RequestBody ProductoRequestdTO requestdTO){
        return productoService.crear(requestdTO);
    }
    @GetMapping
    public List<ProductoResponsetDto> listar(){
        return productoService.listarProductos();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        productoService.eliminar(id);
    }
    @GetMapping("/{id}")
    public ProductoResponsetDto buscarPorId(@PathVariable Long id){
        return productoService.buscarPorId(id);
    }

    @GetMapping("/buscar/{nombre}")
    public List<ProductoResponsetDto> buscarPorNombre(@PathVariable String nombre){
        return productoService.busquedaNombre(nombre);
    }

    //@PatchMapping
    @PutMapping("/{id}")
    public ProductoResponsetDto actualizarProducto(@PathVariable Long id, @Valid @RequestBody ProductoRequestdTO dto) {
        return productoService.actualizar(id, dto);
    }


}
