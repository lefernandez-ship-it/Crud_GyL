package com.gyl.CrudGyl.Repository;

import com.gyl.CrudGyl.Entity.DetalleVenta;
import com.gyl.CrudGyl.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {
    @Override
    Optional<DetalleVenta> findById(Long aLong);

    @Override
    List<DetalleVenta> findAll();

    //List<DetalleVenta>findByNombre(String nombre);

    List<DetalleVenta> findByEstadoDetalleVentaTrue();
    List<DetalleVenta> findByEstadoDetalleVentaFalse();
}
