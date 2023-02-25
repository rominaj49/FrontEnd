
package com.portfolio.mgb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class hys {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int Porcentaje;
    private int color;

    public hys() {
    }

    public hys(String nombre, int Porcentaje, int color) {
        this.nombre = nombre;
        this.Porcentaje = Porcentaje;
        this.color = color;
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
