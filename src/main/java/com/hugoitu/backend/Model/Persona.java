/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Model;

import java.sql.Date;
import javax.persistence.Column;
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
public class Persona {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_persona;
    
    private String nombres;
    private String apellido;
    private Date fecha_nacimiento;
    private String nacionalidad;
    private String mail;
    @Column(columnDefinition = "TEXT")
    private String sobre_mi;
    private String ocupacion;
    private String img_background;
    private String img_perfil;
    private Long id_domicilio;
    
    
}
