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
public class Tecnologia {

    @Override
    public String toString() {
        return "Tecnologia{" + "id_tecnologia=" + id_tecnologia + ", nombre=" + nombre + ", porcentaje=" + porcentaje + ", categoria=" + categoria + ", img=" + img + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Tecnologia other = (Tecnologia) obj;
        if (this.porcentaje != other.porcentaje) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        return Objects.equals(this.id_tecnologia, other.id_tecnologia);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_tecnologia;
    private String nombre;
    private int porcentaje;
    private String categoria;
    private String img;

    
    
}
