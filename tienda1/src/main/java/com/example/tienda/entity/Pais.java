
package com.example.tienda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;


public class Pais {
    
@Entity
@Table (name="paises")
public class pais implements Serializable{
    @Id /*lo que hace que nuestro  atributo de la tabla id*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String pais;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }
    
    
}
    
}
