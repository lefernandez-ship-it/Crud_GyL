package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Request.TipoProdRequestDto;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;
import com.gyl.CrudGyl.Dto.Response.TipoProdResponseDto;
import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Entity.TipoProducto;
import com.gyl.CrudGyl.Exceptions.RecursosNoEncontradoException;
import com.gyl.CrudGyl.Mapper.ProductoMapper;
import com.gyl.CrudGyl.Mapper.TipoProdMapper;
import com.gyl.CrudGyl.Repository.TipoProdRepository;
import com.gyl.CrudGyl.Services.Interfaces.ITipoProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoService implements ITipoProductoService {
    private TipoProdRepository tipoProdRepository;

    public TipoProductoService(TipoProdRepository tipoProdRepository) {this.tipoProdRepository = tipoProdRepository;}

    @Override
    public TipoProdResponseDto crear(TipoProdRequestDto dto) {
        TipoProducto tipoProducto= TipoProdMapper.toEntity(dto);
        tipoProdRepository.save(tipoProducto);
        return TipoProdMapper.toDto(tipoProducto);
    }

    @Override
    public List<TipoProdResponseDto> listarTipoProducto() {
        return tipoProdRepository.findAll()
                .stream()
                .map(TipoProdMapper::toDto)
                .toList();
    }

    @Override
    public TipoProdResponseDto buscarPorId(Long id) {
        return tipoProdRepository.findById(id)
                .map(TipoProdMapper::toDto)
                .orElseThrow(()->new RecursosNoEncontradoException(
                        "No se encontro el id: "+id));
    }

    @Override
    public TipoProdResponseDto actualizar(Long id, TipoProdRequestDto dto) {

        TipoProducto tipoProducto=tipoProdRepository.findById(id).orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro un Tipo Producto con el id: "+id
        ));

        TipoProdMapper.updateEntity(tipoProducto,dto);
        TipoProducto guardado=tipoProdRepository.save(tipoProducto);
        return TipoProdMapper.toDto(guardado);
    }

    @Override
    public void eliminar(Long id) {
        TipoProducto tipoProducto=tipoProdRepository.findById(id)
                .orElseThrow(()-> new RecursosNoEncontradoException(
                        "No se encontro se encontro el id: "+id
                ));

        tipoProdRepository.delete(tipoProducto);
    }

    @Override
    public List<TipoProdResponseDto> busquedaNombre(String nombre) {
        return List.of();
    }

    @Override
    public List<TipoProdResponseDto> listarClientesConEstadoTrue() {

        return tipoProdRepository.findByEstadoTipoProdTrue() // Sin el punto y coma aquí
            .stream()
           .map(TipoProdMapper::toDto)
            .toList();
    }

    @Override
    public TipoProdResponseDto actualizarEstado(Long id, TipoProdRequestDto dto) {

       TipoProducto tipoProducto=tipoProdRepository.findById(id).orElseThrow(()->new RecursosNoEncontradoException(
               "No se encontro un tipo producto con el id: "+id
       ));

       TipoProdMapper.updateEstado(tipoProducto,dto);
       TipoProducto guardado=tipoProdRepository.save(tipoProducto);

       return TipoProdMapper.toDto(guardado);
    }
}


//@Override
//public List<ProductoResponsetDto> listarProductosConEstadoTrue() {
//    return productoRepository.findByEstadoProdTrue() // Sin el punto y coma aquí
//            .stream()
//            .map(ProductoMapper::toDto)
//            .toList();
//}
//
//@Override
//public ProductoResponsetDto buscarPorId(Long id) {//Hacerlo metodo funcional
//    return productoRepository.findById(id)
//            .map(ProductoMapper:: toDto)
//            .orElseThrow(()->new RecursosNoEncontradoException(
//                    "No se encontro el id: "+id));
//}
//

//@Override
//public ProductoResponsetDto actualizar(Long id, ProductoRequestdTO dto) {//Hacerlo metodo funcional
//    Producto producto=productoRepository.findById(id)
//            .orElseThrow(()->new RecursosNoEncontradoException(
//                    "No se encontro el id: "+ id
//            ));
//    ProductoMapper.updateEntity(producto,dto);
//    Producto guardado=productoRepository.save(producto);
//    return ProductoMapper.toDto(guardado);
//
//    // 3. Guardamos la entidad y mapeamos el resultado a ResponseDTO
//
//}
//

