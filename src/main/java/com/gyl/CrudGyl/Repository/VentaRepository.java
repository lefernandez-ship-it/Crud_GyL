package com.gyl.CrudGyl.Repository;

import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VentaRepository extends JpaRepository<Venta,Long> {

    @Override
    List<Venta> findAll();

    @Override
    Optional<Venta> findById(Long aLong);
}
