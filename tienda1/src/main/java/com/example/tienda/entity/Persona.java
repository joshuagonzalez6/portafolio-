
package com.example.tienda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;


public class Persona {
@Entity
@Table(name="persona")
public class persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido1;
    private String apelledo2;
    private String email;       
    
    @ManyToOne /*esto esta relacionado a muchos */
    @JoinColumn(name ="paises_id")
    private Pais pais;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido1() {
            return apellido1;
        }

        public void setApellido1(String apellido1) {
            this.apellido1 = apellido1;
        }

        public String getApelledo2() {
            return apelledo2;
        }

        public void setApelledo2(String apelledo2) {
            this.apelledo2 = apelledo2;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Pais getPais() {
            return pais;
        }

        public void setPais(Pais pais) {
            this.pais = pais;
        }
    
    
}

}
