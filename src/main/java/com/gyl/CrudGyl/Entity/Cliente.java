package com.gyl.CrudGyl.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "Debe ser un correo válido")
    @Column(unique = true)
    private String correo;

    @Pattern(regexp = "^\\d{8}$")
    private String telefono;

    @NotBlank(message = "El nombre es obligatorio")
    private String direccion;

    @Column(name = "estado_cliente", nullable = false)
    private Boolean estadoCliente;

}