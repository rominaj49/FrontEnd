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
public class dtoHys {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private int Porcentaje;
    @NotBlank
    private int color;

    public dtoHys() {
    }

    public dtoHys(String nombre, int Porcentaje, int color) {
        this.nombre = nombre;
        this.Porcentaje = Porcentaje;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(int Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
        
}
