package com.gyl.CrudGyl.Dto.Response;

public record ClienteResponseDto(
        Long id_cliente, // El ID es necesario para identificarlo en el front
        String nombre,
        String apellido,
        String correo,
        String telefono,
        String direccion,
        Boolean estado_cliente
) {
}
