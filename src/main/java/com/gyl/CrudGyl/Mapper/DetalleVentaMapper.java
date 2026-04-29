package com.gyl.CrudGyl.Mapper;

import com.gyl.CrudGyl.Dto.Request.DetalleVentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.DetalleVentaResponseDto;
import com.gyl.CrudGyl.Entity.DetalleVenta;

public class DetalleVentaMapper {
    public DetalleVentaMapper() {
    }
    public static DetalleVenta toEntity(DetalleVentaRequestDto dto){
        DetalleVenta detalleVenta=new DetalleVenta();
        detalleVenta.setCantidad(dto.cantidad());
        detalleVenta.setPrecioUnitario(dto.precioUnitario());
        detalleVenta.setSubTotal(dto.subTotal());
        return detalleVenta;
    }

    public static DetalleVentaResponseDto toDto(DetalleVenta detalleVenta){
        return new DetalleVentaResponseDto(
                detalleVenta.getId_detalle_venta()
                ,detalleVenta.getCantidad()
                ,detalleVenta.getPrecioUnitario()
                ,detalleVenta.getSubTotal()
                ,detalleVenta.getVenta().getId_ventas()
                ,detalleVenta.getProducto().getId_producto()
        );
    }

    public void updateEntity(){

    }
}
