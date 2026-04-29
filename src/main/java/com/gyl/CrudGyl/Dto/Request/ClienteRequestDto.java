package com.gyl.CrudGyl.Dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRequestDto (
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
        String nombre,

        @NotBlank(message = "El apellido es obligatorio")
        @Size(max = 100, message = "El apellido no puede superar los 100 caracteres")
        String apellido,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "Debe ser un correo electrónico válido")
        String correo,

        @NotBlank(message = "El correo es obligatorio")
        String telefono,

        @NotBlank(message = "El correo es obligatorio")
        String direccion,

        @NotNull(message = "El estado es obligatorio") // Se usa NotNull para Booleanos
        Boolean estado_cliente
){

}
