
package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
    //para traer una persona
    public List<Persona>getPersona();
    
    //guardar un objeto del tipo persona
    public void savePersona (Persona persona);
            
    //eliminar un usuario
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}
