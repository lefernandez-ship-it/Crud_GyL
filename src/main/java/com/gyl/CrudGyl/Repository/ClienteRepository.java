package com.gyl.CrudGyl.Repository;

import com.gyl.CrudGyl.Entity.Cliente;
import com.gyl.CrudGyl.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Override
    Optional<Cliente> findById(Long aLong);

    @Override
    List<Cliente> findAll();



//    @Override
//    List<Cliente>findByNombre(String nombre);
}
