/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.DTO;

import com.hugoitu.backend.Model.Enlace;
import java.util.List;

/**
 *
 * @author hugos
 */
public class EducacionDTO {
    
    
    private Long id_education;
    private String img;
    private String titulo;
    private String escuela;
    private String descripcion;
    private int inicio;
    private int fin;
    private List<Enlace> enlaces;
    
}
