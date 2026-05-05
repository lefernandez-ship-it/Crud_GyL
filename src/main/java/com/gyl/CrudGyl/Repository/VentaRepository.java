package com.gyl.CrudGyl.Repository;

import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {

    @Override
    List<Venta> findAll();

    @Override
    Optional<Venta> findById(Long aLong);

    //List<Venta>findByNombre(String nombre);

    List<Venta>findByFechaVenta(LocalDate fecha);

    List<Venta> findByEstadoVentaTrue();
    List<Venta> findByEstadoVentaFalse();
}
