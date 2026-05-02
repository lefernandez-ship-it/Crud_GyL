package com.gyl.CrudGyl.Mapper;

import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Entity.Cliente;
import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Entity.Venta;

public class VentaMapper {
    public VentaMapper() {
    }

    public static Venta toEntity(VentaRequestDto dto){
        Venta venta=new Venta();

        venta.setFechaVenta(dto.fechaVenta());
        venta.setTotal(dto.total());
        venta.setEstadoVenta(dto.estado_venta());
        Cliente cliente = new Cliente();
        cliente.setId_cliente(dto.id_cliente());
        venta.setCliente(cliente);
        return venta;
    }

    public static VentaResponseDto toDto(Venta venta){
        return new VentaResponseDto(
                venta.getId_ventas(),
                venta.getFechaVenta(),
                venta.getTotal(),
                venta.getEstadoVenta(),
                venta.getId_ventas(),
                venta.getDetalles().stream().map(DetalleVentaMapper::toDto).toList() // Mapeo de la lista
        );
    }

    public void updateEntity(Venta venta,VentaResponseDto dto){
        venta.setTotal(dto.total());
        venta.setFechaVenta(dto.fechaVenta());
        venta.setEstadoVenta(dto.estado_venta());
    }

    public static void updateEstado(Venta venta, VentaRequestDto dto){
        venta.setEstadoVenta(dto.estado_venta());
    }
}
