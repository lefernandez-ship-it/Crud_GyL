package com.gyl.CrudGyl.Services;


import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;
import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Exceptions.RecursosNoEncontradoException;
import com.gyl.CrudGyl.Mapper.ProductoMapper;
import com.gyl.CrudGyl.Repository.ProductoRepository;
import com.gyl.CrudGyl.Services.Interfaces.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoResponsetDto crear(ProductoRequestdTO dto) {//Hacerlo un metodo funcional
        Producto producto= ProductoMapper.toEntity(dto);
        Producto guardado=productoRepository.save(producto);
        return ProductoMapper.toDto(guardado);//toResponseDto
    }

    @Override
    public List<ProductoResponsetDto> listarProductos() {

        return productoRepository.findAll()
                .stream()
                .map(ProductoMapper::toDto)
                .toList();
    }

    @Override
    public List<ProductoResponsetDto> listarProductosConEstadoTrue() {
        return productoRepository.findByEstadoProdTrue()
                .stream()
                .map(ProductoMapper::toDto)
                .toList();
    }

    @Override
    public ProductoResponsetDto buscarPorId(Long id) {//Hacerlo metodo funcional
        return productoRepository.findById(id)
                .map(ProductoMapper:: toDto)
                .orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+id));
    }

    @Override
    public ProductoResponsetDto actualizar(Long id, ProductoRequestdTO dto) {//Hacerlo metodo funcional
        Producto producto=productoRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+ id
                ));
        ProductoMapper.updateEntity(producto,dto);
        Producto guardado=productoRepository.save(producto);
        return ProductoMapper.toDto(guardado);

        // 3. Guardamos la entidad y mapeamos el resultado a ResponseDTO

    }

    @Override
    public void eliminar(Long id) {
        Producto producto=productoRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+ id
                ));
        productoRepository.delete(producto);
    }

    @Override
    public List<ProductoResponsetDto> busquedaNombre(String nombre){
        List<Producto> productos = productoRepository.findByNombre(nombre);
        if (productos.isEmpty()) {
            throw new RecursosNoEncontradoException("No se encontraron productos con el nombre: " + nombre);
        }
        return productoRepository.findByNombre(nombre)
                .stream()
                .map(ProductoMapper:: toDto)
                .toList();
    }


}
