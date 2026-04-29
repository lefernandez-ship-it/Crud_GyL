package com.gyl.CrudGyl.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo_productos")
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_producto;

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String nombre;

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String descripcion;

    @NotNull(message = "El estado es obligatorio") // Se usa NotNull para Booleanos
    Boolean estado_tipoProd;

    // Constructores, Getters y Setters
}
