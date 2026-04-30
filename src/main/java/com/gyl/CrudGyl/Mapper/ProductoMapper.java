package com.gyl.CrudGyl.Mapper;

import com.gyl.CrudGyl.Dto.Request.ProductoRequestdTO;
import com.gyl.CrudGyl.Dto.Response.ProductoResponsetDto;
import com.gyl.CrudGyl.Entity.Producto;

public class ProductoMapper {
    private ProductoMapper(){

    }
    public static Producto toEntity(ProductoRequestdTO dto){
        Producto producto=new Producto();

        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
        producto.setEstadoProd(dto.estado_prod());
        //producto.setTipoProducto(dto.id_tipo_producto());

        return producto;
    }
    public static ProductoResponsetDto toDto(Producto producto){

        return  new ProductoResponsetDto(
                producto.getId_producto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstadoProd(),
                producto.getTipoProducto() != null ? producto.getTipoProducto().getId_tipo_producto() : null
        );
    }
    public static void updateEntity(Producto producto,ProductoRequestdTO dto){
        producto.setNombre(dto.nombre());
        producto.setStock(dto.stock());
        producto.setPrecio(dto.precio());
        producto.setEstadoProd(dto.estado_prod());
    }

    public static void updateEstado(Producto producto,ProductoRequestdTO dto){
        producto.setEstadoProd(dto.estado_prod());
    }


}
