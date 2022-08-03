/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.DTO;

import com.hugoitu.backend.Model.Enlace;
import com.hugoitu.backend.Model.Tecnologia;
import java.util.List;

/**
 *
 * @author hugos
 */
public class ProyectoDTO {
    
    
    private Long id_proyecto;
    private String img;
    private String title;
    private String description;
    List<Tecnologia> tecnologias;
    List<Enlace> enlaces;
    
    
}
