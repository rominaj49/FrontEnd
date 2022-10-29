package com.portfolio.mgb.Dto;

import javax.validation.constraints.NotBlank;

//aca traemos los mismos campos de educacion
public class dtoEducacion {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String institutoE;
    @NotBlank
    private String descripcionE;

    
        // constructor vacio

    public dtoEducacion() {
    }

    // constructor lleno
    public dtoEducacion(String nombreE, String institutoE, String descripcionE) {
        this.nombreE = nombreE;
        this.institutoE = institutoE;
        this.descripcionE = descripcionE;
    }

    //getter and setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getInstitutoE() {
        return institutoE;
    }

    public void setInstitutoE(String institutoE) {
        this.institutoE = institutoE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
}
