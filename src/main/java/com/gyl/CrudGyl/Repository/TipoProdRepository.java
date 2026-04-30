package com.gyl.CrudGyl.Repository;

import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoProdRepository extends JpaRepository<TipoProducto,Long> {

    @Override
    List<TipoProducto> findAll();

    @Override
    Optional<TipoProducto> findById(Long aLong);

    List<Producto>findByNombre(String nombre);

    List<Producto> findByEstadoTipoProdTrue(); //Ver el metodo y como se llama
}
