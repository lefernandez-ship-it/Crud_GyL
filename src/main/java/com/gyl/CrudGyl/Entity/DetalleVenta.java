package com.gyl.CrudGyl.Entity;

import com.gyl.CrudGyl.Mapper.ProductoMapper;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_ventas")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_venta;

    private Integer cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "sub_total")
    private BigDecimal subTotal;

    @NotNull(message = "El estado es obligatorio") // Se usa NotNull para Booleanos
    Boolean estado_detalleVenta;

    // Relación con la Venta (FK id_ventas)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ventas", nullable = false)
    private Venta venta;

    // Relación con el Producto (FK id_producto)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    // Constructores, Getters y Setters
}