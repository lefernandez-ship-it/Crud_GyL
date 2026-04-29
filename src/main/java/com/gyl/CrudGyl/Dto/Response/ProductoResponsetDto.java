package com.gyl.CrudGyl.Dto.Response;

public record ProductoResponsetDto (
        Long id_producto,
        String nombre,
        Double precio,
        Integer stock,
        Boolean estado_prod,
        Long id_tipoProd

){

}
