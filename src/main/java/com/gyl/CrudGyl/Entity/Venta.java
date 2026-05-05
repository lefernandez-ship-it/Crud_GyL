package com.gyl.CrudGyl.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ventas;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    private BigDecimal total;

    @NotNull(message = "El estado es obligatorio") // Se usa NotNull para Booleanos
    @Column(name = "estado_venta")
    Boolean estadoVenta;


    // La FK id_cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalles;


    @PrePersist
    protected void onCreate() {
        this.fechaVenta = LocalDateTime.now();
        if (this.estadoVenta == null) this.estadoVenta = true; // Valor por defecto
    }

    public void addDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
        detalle.setVenta(this); // Esto asegura que el detalle sepa a qué venta pertenece
    }

    // Constructores, Getters y Setters
}
