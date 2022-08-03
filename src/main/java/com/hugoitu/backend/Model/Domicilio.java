/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Model;

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
public class Domicilio {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_domicilio;

    @Override
    public String toString() {
        return "Domicilio{" + "id_domicilio=" + id_domicilio + ", calle=" + calle + ", ciudad=" + ciudad + '}';
    }
    private String calle;
    private String ciudad;
    
}
