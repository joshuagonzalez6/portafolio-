
package com.example.tienda.repository;

import com.example.tienda.entity.Pais;
import com.example.tienda.service.IPaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaisService implements IPaisService {
    
    @Autowired /* crea el puente o una conexion de ambo mundo ( a una istancia servio pais a repositoryo pais*/
    private PaisRepository paisRepository;
    
    @Override
    public List<Pais> listCountry (){
        return (List<Pais>)paisRepository.findAll(); }
    }





