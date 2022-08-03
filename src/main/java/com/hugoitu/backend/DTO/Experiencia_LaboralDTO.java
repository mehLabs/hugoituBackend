/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.DTO;

import com.hugoitu.backend.Model.Enlace;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hugos
 */
@Setter @Getter
public class Experiencia_LaboralDTO {
    
    private Long id_experiencia_laboral;
    private String inicio;
    private String fin;
    private String posicion;
    private String descripcion;
    private String empresa;
    private String img;
    private List<Enlace> enlaces;
    
}
