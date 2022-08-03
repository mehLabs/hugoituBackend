/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hugos
 */
@Entity
@Setter @Getter
public class Experiencia_Laboral {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id_experiencia_laboral);
        hash = 53 * hash + Objects.hashCode(this.color);
        hash = 53 * hash + (this.opcional ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.inicio);
        hash = 53 * hash + Objects.hashCode(this.fin);
        hash = 53 * hash + Objects.hashCode(this.posicion);
        hash = 53 * hash + Objects.hashCode(this.descripcion);
        hash = 53 * hash + Objects.hashCode(this.empresa);
        hash = 53 * hash + Objects.hashCode(this.img);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Experiencia_Laboral other = (Experiencia_Laboral) obj;
        if (this.opcional != other.opcional) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fin, other.fin)) {
            return false;
        }
        if (!Objects.equals(this.posicion, other.posicion)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        return Objects.equals(this.id_experiencia_laboral, other.id_experiencia_laboral);
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_experiencia_laboral;
    private String color;
    private boolean opcional;
    private String inicio;
    private String fin;
    private String posicion;
    private String descripcion;
    private String empresa;
    private String img;
    
    
    
}
