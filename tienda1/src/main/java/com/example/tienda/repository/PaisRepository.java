
package com.example.tienda.repository;
import com.example.tienda.entity.Pais;
import com.example.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais,Long>{
    Persona findBYNombre (String nombre);
    }


