/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.mgb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class proyecto {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    private String nombre;
    private String descripcion;
    private String githubLink;
    private String pageLink;

    public proyecto() {
    }

    public proyecto(String nombre, String descripcion, String githubLink, String pageLink) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.githubLink = githubLink;
        this.pageLink = pageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }
    
    
    
}
