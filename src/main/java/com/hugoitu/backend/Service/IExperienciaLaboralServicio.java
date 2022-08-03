/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Experiencia_Laboral;
import java.util.List;

/**
 *
 * @author hugos
 */
public interface IExperienciaLaboralServicio {
    
    public List<Experiencia_Laboral> getExperienciasLaborales();
    
    public Experiencia_Laboral getExperienciaLaboral(Long id);
    
    public boolean saveExperienciaLaboral(Experiencia_Laboral experienciaLaboral);
    
    public boolean deleteExperienciaLaboral(Long id);
    
}
