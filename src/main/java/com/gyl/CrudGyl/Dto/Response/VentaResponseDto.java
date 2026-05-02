package com.gyl.CrudGyl.Dto.Response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VentaResponseDto (

        Long id_ventas,

        LocalDateTime fechaVenta,

        BigDecimal total,

        Boolean estado_venta,

        Long id_cliente,
        List<DetalleVentaResponseDto> detalles//Es el id no el objeto

){
}
