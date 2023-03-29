package com.example.tienda.controller;


import com.example.tienda.entity.Pais;
import com.example.tienda.entity.Persona;
import com.example.tienda.entity.Persona.persona;
import com.example.tienda.service.IPaisService;
import com.example.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {
    
    @Autowired /*Lo que hace un autowired es buscar un objeto manejado (beans) que implementen determinada interfaz para hacer referencia a él. DE esta manera no es neceario crear una instancia nueva del objeto cada vez que se necesite la funcionalidad de determinada claseLo que hace un autowired es buscar un objeto manejado (beans) que implementen determinada interfaz para hacer referencia a él. DE esta manera no es neceario crear una instancia nueva del objeto cada vez que se necesite la funcionalidad de determinada clase*/
    private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;
    
    @GetMapping("/persona")
    public String index(Model model) {
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Persona");
        model.addAttribute("persona",listaPersona);
        return "persona";
    }
    @GetMapping("/personaN")
   public String crearPersona(Model model){
       List<Pais> listaPaises = paisService.listCountry();
       model.addAttribute("persona",new Persona ());
       model.addAttribute("paises",listaPaises);
       return "crear";      
   }
   @GetMapping("/delete{id}")
   public String eliminarPersona(@PathVariable("id") long idPersona){
       personaService.savePersona(idPersona);
       return "redirect:/persona";      
   }
   @PostMapping("/save") /*se utiliza para asignar solicitudes de publicación HTTP a controladores específicos*/
   public String guardarPersona(@ModelAttribute Persona persona){
       personaService.savePersona(persona);
       return "redirect:/persona"; /*nos redirige(redirect)*/
   }
   @GetMapping("/ediPersona/(id)")
   public String editarPersona (@PathVariable("id")Long idPersona, Model model) {
       Persona persona = personaService.getPersonaById(idPersona);
       List<Pais>listaPaises = paisService.listCountry();
       model.addAttribute("persona",persona);
       model.addAttribute("paises", listaPaises);
       return"crear";
   }
}
