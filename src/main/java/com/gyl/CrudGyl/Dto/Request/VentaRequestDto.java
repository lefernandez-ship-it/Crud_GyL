package com.gyl.CrudGyl.Dto.Request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaRequestDto(

         @NotNull(message = "La fecha de venta es obligatoria")
         @PastOrPresent(message = "La fecha no puede ser futura")
         LocalDateTime fechaVenta,

         @NotNull(message = "El monto total es obligatorio")
         @DecimalMin(value = "0.0", inclusive = false, message = "El total debe ser mayor a cero")
         BigDecimal total,

         @NotNull(message = "El cliente es obligatorio")
         Long id_cliente, // Agregado para asociar la venta al cliente

         @NotNull(message = "El estado es obligatorio") // Se usa NotNull para Booleanos
         Boolean estado_venta
) {
}
