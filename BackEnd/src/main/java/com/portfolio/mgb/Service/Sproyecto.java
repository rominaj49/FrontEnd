/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.proyecto;
import com.portfolio.mgb.Repository.Rproyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Transactional
@Service
public class Sproyecto {
   
    @Autowired
     Rproyecto rproyecto;  
  
  public List<proyecto> list(){
      return rproyecto.findAll();
  }
  
  public Optional<proyecto> getOne(int id){
      return rproyecto.findById(id);
  }
  
  public Optional<proyecto> getByNombre(String nombre){
        return rproyecto.findByNombre(nombre);
    }
  
  public void save(proyecto educacion){
      rproyecto.save(educacion);
  }
  
  public void delete(int id){
      rproyecto.deleteById(id);
  }
  
  public boolean existsById(int id){
      return rproyecto.existsById(id);
  }
  
  public boolean existsByNombre(String nombre){
      return rproyecto.existsByNombre(nombre);
  }
}
