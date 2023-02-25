/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoProyecto;
import com.portfolio.mgb.Entity.proyecto;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.Sproyecto;
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

/**
 *
 * @author HP
 */
@RestController
@CrossOrigin (origins = {"http://localhost:4200","https://frontendprueba-ea33f.web.app"})
@RequestMapping("/proyecto")
public class CProyecto {
    
     @Autowired
    Sproyecto sproyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<proyecto>> list() {
        List<proyecto> list = sproyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<proyecto> getById(@PathVariable("id") int id) {
        if (!sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyecto proYecto = sproyecto.getOne(id).get();
        return new ResponseEntity(proYecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sproyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproy) {
        if (StringUtils.isBlank(dtoproy.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sproyecto.existsByNombre(dtoproy.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        proyecto proYecto = new proyecto(dtoproy.getNombre(), dtoproy.getDescripcion(), dtoproy.getGithubLink(),dtoproy.getPageLink());
        sproyecto.save(proYecto);

        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproy) {
        //Validamos si existe el ID
        if (!sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sproyecto.existsByNombre(dtoproy.getNombre()) && sproyecto.getByNombre(dtoproy.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoproy.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        proyecto proYecto = sproyecto.getOne(id).get();
        proYecto.setNombre(dtoproy.getNombre());
        proYecto.setDescripcion(dtoproy.getDescripcion());
        proYecto.setGithubLink(dtoproy.getGithubLink());
        proYecto.setPageLink(dtoproy.getPageLink());


        sproyecto.save(proYecto);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

}
}