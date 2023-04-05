
package com.example.tienda.service;

import com.example.tienda.entity.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getAllPersona();
    public Persona getPersonaById (long id);
    public void savePersona(Persona persona);
    public void delete (long id);
    public Persona findByNombre(String username);
    public void savePersona(long idPersona);
}
