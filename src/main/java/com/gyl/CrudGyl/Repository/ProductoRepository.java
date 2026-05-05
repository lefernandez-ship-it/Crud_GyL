package com.gyl.CrudGyl.Repository;

import com.gyl.CrudGyl.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//Bean clases tipo objeto
@Repository
public interface ProductoRepository  extends JpaRepository<Producto,Long> {

    @Override
    List<Producto> findAll();

    @Override
    Optional<Producto> findById(Long aLong);

    List<Producto>findByNombre(String nombre);

    List<Producto> findByEstadoProdTrue();
    List<Producto> findByEstadoProdFalse();



}
