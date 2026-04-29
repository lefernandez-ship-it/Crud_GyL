package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.TipoProdRequestDto;
import com.gyl.CrudGyl.Dto.Response.TipoProdResponseDto;
import com.gyl.CrudGyl.Entity.TipoProducto;
import com.gyl.CrudGyl.Exceptions.RecursosNoEncontradoException;
import com.gyl.CrudGyl.Mapper.TipoProdMapper;
import com.gyl.CrudGyl.Repository.TipoProdRepository;
import com.gyl.CrudGyl.Services.Interfaces.ITipoProductoService;

import java.util.List;

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
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<TipoProdResponseDto> busquedaNombre(String nombre) {
        return List.of();
    }
}
