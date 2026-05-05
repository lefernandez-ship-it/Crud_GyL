package com.gyl.CrudGyl.Services;


import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;
import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Entity.TipoProducto;
import com.gyl.CrudGyl.Exceptions.RecursosNoEncontradoException;
import com.gyl.CrudGyl.Mapper.ProductoMapper;
import com.gyl.CrudGyl.Repository.ProductoRepository;
import com.gyl.CrudGyl.Repository.TipoProdRepository;
import com.gyl.CrudGyl.Services.Interfaces.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
public class ProductoService implements IProductoService {

    private ProductoRepository productoRepository;
    private TipoProdRepository tipoProdRepository;

    public ProductoService(ProductoRepository productoRepository, TipoProdRepository tipoProdRepository) {
        this.productoRepository = productoRepository;
        this.tipoProdRepository = tipoProdRepository;
    }

    @Override
    public ProductoResponsetDto crear(ProductoRequestdTO dto) {//Hacerlo un metodo funcional
        Producto producto= ProductoMapper.toEntity(dto);
        TipoProducto tipo = tipoProdRepository.findById(dto.id_tipo_producto())
                .orElseThrow(() -> new RecursosNoEncontradoException("Categoría no encontrada"));
        producto.setTipoProducto(tipo);
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
        return productoRepository.findByEstadoProdTrue() // Sin el punto y coma aquí
                .stream()
                .map(ProductoMapper::toDto)
                .toList();
    }

    @Override
    public List<ProductoResponsetDto> listarProductosConEstadoFalse() {
        return productoRepository.findByEstadoProdFalse() // Sin el punto y coma aquí
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
    public ProductoResponsetDto actualizarEstado(Long id, ProductoRequestdTO dto) {
        Producto producto=productoRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+id
                ));

        ProductoMapper.updateEstado(producto,dto);
        Producto guardado=productoRepository.save(producto);
        return ProductoMapper.toDto(guardado);
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
