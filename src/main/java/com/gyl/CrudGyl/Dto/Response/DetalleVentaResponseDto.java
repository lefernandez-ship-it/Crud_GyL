package com.gyl.CrudGyl.Dto.Response;

import java.math.BigDecimal;

public record DetalleVentaResponseDto(

         Long id_detalle_venta,

         Integer cantidad,

         BigDecimal precioUnitario,

         BigDecimal subTotal,

         Boolean estado_detalleVenta,

         Long  id_venta,

         Long id_producto

) {
}
