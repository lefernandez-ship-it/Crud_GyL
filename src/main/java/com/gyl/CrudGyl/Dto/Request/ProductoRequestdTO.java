package com.gyl.CrudGyl.Dto.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

//Create, delete y update
public record ProductoRequestdTO (

        @NotBlank(message ="El nombre no puede ser vacio")
        String nombre,

//        @NotBlank(message="El precio no puede ser vacio")
        @Positive(message="El precio debe ser mayor a cero")
        @NotNull(message ="El nombre no puede ser negativo")
        Double precio,

//        @NotBlank(message ="El stock no puede estar vacio")
        @Positive(message="El stock debe ser cero o mayor")//Que sea positivo
        @Min(value=0,message = "El stock no puede ser negativo")
        Integer stock,

        @NotNull(message = "El estado es obligatorio") // Se usa NotNull para Booleanos
        Boolean estado_prod
){



}
