package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoPersona;
import com.portfolio.mgb.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.ImpPersonaService;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin (origins = {"http://localhost:4200","https://frontendprueba-ea33f.web.app"})

@RequestMapping("/personas")

public class PersonaController {
  @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    
      @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
   
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")

    public ResponseEntity<?> create(@RequestBody dtoEducacion dtopersona) {
        if (StringUtils.isBlank(dtopersona.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existsByNombreE(dtopersona.getNombreE())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        }
//ACA LE AGREGUE ALGO EXTRA DTOEDUCACION.GETINSTITUTOE
        Educacion persona = new Educacion(
                dtopersona.getNombreE(), dtopersona.getInstitutoE(), dtopersona.getDescripcionE()
        );

        personaService.save(persona);

        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {

        //VALIDA SI EXISTE ID 
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //COMPARA NOMBRE DE LAS EDUCACIONES abria que hacer lo mismo con descripcion e institucion o capaz instituto no
        if (personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        //No puede estar vacio
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get(); //traemos el id
        //actualizamos parametros
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion((dtopersona.getDescripcion()));
        //ACA AGREGUE ALGO EXTRA SETINSTITUTO
        persona.setImg((dtopersona.getImg()));
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Perfil actualizado!"), HttpStatus.OK);

    }
}
