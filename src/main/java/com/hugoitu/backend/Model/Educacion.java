/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Model;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hugos
 */
@Entity
@Getter @Setter
public class Educacion {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id_education);
        hash = 31 * hash + (this.opcional ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.img);
        hash = 31 * hash + Objects.hashCode(this.titulo);
        hash = 31 * hash + Objects.hashCode(this.escuela);
        hash = 31 * hash + Objects.hashCode(this.descripcion);
        hash = 31 * hash + this.inicio;
        hash = 31 * hash + this.fin;
        hash = 31 * hash + Objects.hashCode(this.id_enlace);
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
        final Educacion other = (Educacion) obj;
        if (this.opcional != other.opcional) {
            return false;
        }
        if (this.inicio != other.inicio) {
            return false;
        }
        if (this.fin != other.fin) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.escuela, other.escuela)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id_education, other.id_education)) {
            return false;
        }
        return Objects.equals(this.id_enlace, other.id_enlace);
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_education;
    private boolean opcional;
    private String img;
    private String titulo;
    private String escuela;
    private String descripcion;
    private int inicio;
    private int fin;
    private Long id_enlace;
    
    /*
    @OneToMany(cascade = CascadeType.ALL)
    private List<Enlace> enlaces;
    */    

}
