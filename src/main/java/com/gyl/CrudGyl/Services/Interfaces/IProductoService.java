package com.gyl.CrudGyl.Services.Interfaces;

import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;

import java.util.List;

public interface IProductoService {

    ProductoResponsetDto crear(ProductoRequestdTO dto);

    List<ProductoResponsetDto> listarProductos();

    List<ProductoResponsetDto> listarProductosConEstadoTrue();

    ProductoResponsetDto buscarPorId(Long id);

    ProductoResponsetDto actualizarEstado(Long id,ProductoRequestdTO dto);

    ProductoResponsetDto actualizar(Long id,ProductoRequestdTO dto);

    void eliminar(Long id);

    List<ProductoResponsetDto> busquedaNombre(String nombre);
}
