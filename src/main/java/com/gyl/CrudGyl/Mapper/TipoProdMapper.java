package com.gyl.CrudGyl.Mapper;

import com.gyl.CrudGyl.Dto.Request.TipoProdRequestDto;
import com.gyl.CrudGyl.Dto.Response.TipoProdResponseDto;
import com.gyl.CrudGyl.Entity.TipoProducto;

public class TipoProdMapper {
    public TipoProdMapper() {
    }
    public static TipoProducto toEntity(TipoProdRequestDto dto){
        TipoProducto tipoProducto=new TipoProducto();
        tipoProducto.setDescripcion(dto.descripcion());
        tipoProducto.setNombre(dto.nombre());
        return tipoProducto;
    }

    public static TipoProdResponseDto toDto(TipoProducto tipoProducto){

        return new TipoProdResponseDto(
                tipoProducto.getId_tipo_producto(),
                tipoProducto.getNombre(),
                tipoProducto.getDescripcion(),
                tipoProducto.getEstado_tipoProd()
        );
    }
    public void updateEntity(TipoProducto tipoProducto,TipoProdResponseDto tipoProdResponseDto){
        tipoProducto.setNombre(tipoProdResponseDto.nombre());
        tipoProducto.setDescripcion(tipoProducto.getDescripcion());
        tipoProducto.setEstado_tipoProd(tipoProdResponseDto.estado_Tipoprod());
    }
}
