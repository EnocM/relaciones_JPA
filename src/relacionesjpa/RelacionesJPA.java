/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionesjpa;

import Controladores.PersonadiagramaJpaController;
import Entidades.Personadiagrama;
import java.util.List;

/**
 *
 * @author alumno
 */
public class RelacionesJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
        PersonadiagramaJpaController personaController = new PersonadiagramaJpaController();
        Personadiagrama p = new Personadiagrama(2,"Marcos","Figueroa");
        personaController.create(p);
        
        List<Personadiagrama> listado = personaController.findPersonadiagramaEntities();
        
        //List<Persona> listado = personaController.findPersonaEntitiesJpql3("maria");
        
        Personadiagrama persona = new Personadiagrama();
        personaController.edit(persona);
        
        
        for(Personadiagrama p1: listado)
            {
                System.out.println(p1);
            }
    }catch(Exception ex)
            {
                System.out.println("error: "+ ex.getMessage());
            }
        
    }
    
}
