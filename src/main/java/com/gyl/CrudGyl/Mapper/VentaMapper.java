package com.gyl.CrudGyl.Mapper;

import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Entity.Venta;

public class VentaMapper {
    public VentaMapper() {
    }

    public static Venta toEntity(VentaRequestDto dto){
        Venta venta=new Venta();

        venta.setFechaVenta(dto.fechaVenta());
        venta.setTotal(dto.total());
        venta.setEstado_venta(dto.estado_venta());
        return venta;
    }

    public static VentaResponseDto toDto(Venta venta){
        return new VentaResponseDto(
                venta.getId_ventas(),
                venta.getFechaVenta(),
                venta.getTotal(),
                venta.getEstado_venta(),
                venta.getId_ventas()
        );
    }

    public void updateEntity(Venta venta,VentaResponseDto dto){
        venta.setTotal(dto.total());
        venta.setFechaVenta(dto.fechaVenta());
        venta.setEstado_venta(dto.estado_venta());
    }
}
