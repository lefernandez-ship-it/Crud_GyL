package com.gyl.CrudGyl.Dto.Request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DetalleVentaRequestDto (

         @NotNull
         Integer cantidad,

         @NotNull
         BigDecimal precioUnitario,

         @NotNull
         BigDecimal subTotal,


         @NotNull(message = "El producto es obligatorio")
         Long id_producto, // Agregado para la relación

         @NotNull(message = "La venta es obligatoria")
         Long id_venta, // Agregado para la relación

         @NotNull(message = "El estado es obligatorio") // Se usa NotNull para Booleanos
         Boolean estado_detalleVenta


){
}
