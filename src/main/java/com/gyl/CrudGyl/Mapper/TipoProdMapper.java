package com.gyl.CrudGyl.Mapper;

import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Request.TipoProdRequestDto;
import com.gyl.CrudGyl.Dto.Response.TipoProdResponseDto;
import com.gyl.CrudGyl.Entity.Producto;
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
                tipoProducto.getEstadoTipoProd()
        );
    }
    public void updateEntity(TipoProducto tipoProducto,TipoProdResponseDto tipoProdResponseDto){
        tipoProducto.setNombre(tipoProdResponseDto.nombre());
        tipoProducto.setDescripcion(tipoProducto.getDescripcion());
        tipoProducto.setEstadoTipoProd(tipoProdResponseDto.estado_Tipoprod());
    }

    public static void updateEstado(TipoProducto tipoProducto, TipoProdRequestDto dto){
        tipoProducto.setEstadoTipoProd(dto.estado_tipoProd());
    }
}
