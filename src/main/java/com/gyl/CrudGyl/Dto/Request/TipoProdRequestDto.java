package com.gyl.CrudGyl.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TipoProdRequestDto(

        @NotBlank(message = "El nombre es obligatorio")
         String nombre,

        @NotBlank(message = "El nombre es obligatorio")
         String descripcion,

        @NotNull(message = "El estado es obligatorio") // Se usa NotNull para Booleanos
        Boolean estado_tipoProd
) {
}
