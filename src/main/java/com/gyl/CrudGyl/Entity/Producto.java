package com.gyl.CrudGyl.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO
    private Long id_producto;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "estado_prod", nullable = false)
    private Boolean estadoProd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_producto", nullable = false)
    private TipoProducto tipoProducto;







}

