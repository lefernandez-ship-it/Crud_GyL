package com.gyl.CrudGyl.Repository;

import com.gyl.CrudGyl.Entity.Cliente;
import com.gyl.CrudGyl.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Override
    Optional<Cliente> findById(Long aLong);

    @Override
    List<Cliente> findAll();

    List<Cliente>findByNombre(String nombre);

    List<Cliente> findByEstadoClienteTrue();

//    @Override
//    List<Cliente>findByNombre(String nombre);
}
