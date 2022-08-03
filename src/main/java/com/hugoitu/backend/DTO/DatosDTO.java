/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.DTO;

import com.hugoitu.backend.Model.Domicilio;
import com.hugoitu.backend.Model.Educacion;
import com.hugoitu.backend.Model.Experiencia_Laboral;
import com.hugoitu.backend.Model.Persona;
import com.hugoitu.backend.Model.Proyecto;
import com.hugoitu.backend.Model.Tecnologia;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hugos
 */
@Getter @Setter
public class DatosDTO {
    
    private Persona persona;
    private Domicilio domicilio;
    private List<Experiencia_Laboral> experienciaLaboral;
    private List<Proyecto> proyectos;
    private List<Tecnologia> tecnologias;
    private List<Educacion> educacion;
    
    
}
