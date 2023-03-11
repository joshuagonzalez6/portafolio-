
package com.example.tienda.entity;


public class persona {
 import javax.persistence.table;
    
    
 @entity
 @table(name="persona")
 public class persona implements serializable{

        public string getNombre() {
            return nombre;
        }

        public void setNombre(string nombre) {
            this.nombre = nombre;
        }

        public string getApellido1() {
            return apellido1;
        }

        public void setApellido1(string apellido1) {
            this.apellido1 = apellido1;
        }

        public string getApellido2() {
            return apellido2;
        }

        public void setApellido2(string apellido2) {
            this.apellido2 = apellido2;
        }

        public string getTelefono() {
            return telefono;
        }

        public void setTelefono(string telefono) {
            this.telefono = telefono;
        }

        public string getEmail() {
            return email;
        }

        public void setEmail(string email) {
            this.email = email;
        }

        public pais getPais() {
            return pais;
        }

        public void setPais(pais pais) {
            this.pais = pais;
        }
 @id
 @generatedvalue(strategy=generationType.IDENTITY)
 private class id
         
  private string nombre;
  private string apellido1;
  private string apellido2;
  private string telefono;       
  private string email;
  
  @manyToOne
  @joincolumn(name="paises_id")
  private pais pais;
  
 
 }
 }
