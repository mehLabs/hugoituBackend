/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Model;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Proyecto {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id_proyecto);
        hash = 47 * hash + Objects.hashCode(this.img);
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.id_tecnologia);
        hash = 47 * hash + Objects.hashCode(this.id_enlace);
        hash = 47 * hash + Objects.hashCode(this.enlace);
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
        final Proyecto other = (Proyecto) obj;
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.enlace, other.enlace)) {
            return false;
        }
        if (!Objects.equals(this.id_proyecto, other.id_proyecto)) {
            return false;
        }
        if (!Objects.equals(this.github, other.github)) {
            return false;
        }
        if (!Objects.equals(this.id_tecnologia, other.id_tecnologia)) {
            return false;
        }
        return Objects.equals(this.id_enlace, other.id_enlace);
    }
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_proyecto;
    private String img;
    private String title;
    @Column(length = 3000) 
    private String description;
    private Long id_tecnologia;
    private Long id_enlace;
    private String enlace;
    private String github;
    
    /*
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tecnologia> tecnologias;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Enlace> enlaces;
    */
    
}
