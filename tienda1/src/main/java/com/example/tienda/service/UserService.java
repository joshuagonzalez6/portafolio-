
package com.example.tienda.service;

import com.example.tienda.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class UserService implements  UserDetailsService{
   
    @Autowired
    public IPersonaService personaService;

    public UserService() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public UserService() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public UserService() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
        Persona persona = this.personaService.findByNombre(username);
        Userprincipal userPrincipal =  new Userprincipal(persona);
        return (UserDetails) userPrincipal;
    }
    
}
