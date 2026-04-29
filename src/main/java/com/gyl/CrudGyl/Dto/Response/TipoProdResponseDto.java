package com.gyl.CrudGyl.Dto.Response;

public record TipoProdResponseDto(
         Long id_tipo_producto,
         String nombre,
         String descripcion,
         Boolean estado_Tipoprod
) {
}
