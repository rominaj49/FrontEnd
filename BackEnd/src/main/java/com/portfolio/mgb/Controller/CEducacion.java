package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoEducacion;
import com.portfolio.mgb.Entity.Educacion;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.Seducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = {"http://localhost:4200","https://frontendprueba-ea33f.web.app"})
@RequestMapping("/educacion")
//@CrossOrigin(origins = "https://frontendprueba-ea33f.web.app")

public class CEducacion {

    @Autowired
    Seducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    
      @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
   
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")

    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion) {
        if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sEducacion.existsByNombreE(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        }
//ACA LE AGREGUE ALGO EXTRA DTOEDUCACION.GETINSTITUTOE
        Educacion educacion = new Educacion(
                dtoeducacion.getNombreE(), dtoeducacion.getInstitutoE(), dtoeducacion.getDescripcionE()
        );

        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion) {

        //VALIDA SI EXISTE ID 
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //COMPARA NOMBRE DE LAS EDUCACIONES abria que hacer lo mismo con descripcion e institucion o capaz instituto no
        if (sEducacion.existsByNombreE(dtoeducacion.getNombreE()) && sEducacion.getByNombreE(dtoeducacion.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        //No puede estar vacio
        if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get(); //traemos el id
        //actualizamos parametros
        educacion.setNombreE(dtoeducacion.getNombreE());
        educacion.setDescripcionE((dtoeducacion.getDescripcionE()));
        //ACA AGREGUE ALGO EXTRA SETINSTITUTO
        educacion.setInstitutoE((dtoeducacion.getInstitutoE()));
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);

    }
}
