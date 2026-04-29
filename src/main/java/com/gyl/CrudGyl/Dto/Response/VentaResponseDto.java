package com.gyl.CrudGyl.Dto.Response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaResponseDto (

         Long id_ventas,

         LocalDateTime fechaVenta,

         BigDecimal total,

         Boolean estado_venta,

         Long id_cliente //Es el id no el objeto

){
}
