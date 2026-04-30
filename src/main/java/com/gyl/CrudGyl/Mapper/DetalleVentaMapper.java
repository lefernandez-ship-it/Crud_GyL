package com.gyl.CrudGyl.Mapper;

import com.gyl.CrudGyl.Dto.Request.DetalleVentaRequestDto;
import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.DetalleVentaResponseDto;
import com.gyl.CrudGyl.Entity.DetalleVenta;
import com.gyl.CrudGyl.Entity.Producto;

public class DetalleVentaMapper {
    public DetalleVentaMapper() {
    }
    public static DetalleVenta toEntity(DetalleVentaRequestDto dto){
        DetalleVenta detalleVenta=new DetalleVenta();
        detalleVenta.setCantidad(dto.cantidad());
        detalleVenta.setPrecioUnitario(dto.precioUnitario());
        detalleVenta.setSubTotal(dto.subTotal());
        detalleVenta.setEstadoDetalleVenta(dto.estado_detalleVenta());
        return detalleVenta;
    }

    public static DetalleVentaResponseDto toDto(DetalleVenta detalleVenta){
        return new DetalleVentaResponseDto(
                detalleVenta.getId_detalle_venta()
                ,detalleVenta.getCantidad()
                ,detalleVenta.getPrecioUnitario()
                ,detalleVenta.getSubTotal()
                ,detalleVenta.getEstadoDetalleVenta()
                ,detalleVenta.getVenta().getId_ventas()
                ,detalleVenta.getProducto().getId_producto()
        );
    }

    public void updateEntity(){

    }

    public static void updateEstado(DetalleVenta detalleVenta, DetalleVentaRequestDto dto){
        detalleVenta.setEstadoDetalleVenta(dto.estado_detalleVenta());
    }
}
