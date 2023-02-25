/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.mgb.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author HP
 */
public class dtoProyecto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String githubLink;
    @NotBlank
    private String pageLink;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String descripcion, String githubLink, String pageLink) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.githubLink = githubLink;
        this.pageLink = pageLink;
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
