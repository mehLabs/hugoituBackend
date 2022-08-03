/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Educacion;
import java.util.List;

/**
 *
 * @author hugos
 */
public interface IEducacionServicio {
    
    public List<Educacion> getEducacion();
    
    public Educacion getEstudio(Long id);
    
    public boolean saveEducacion(Educacion educacion);
    
    public boolean DeleteEducacion(Long id);
    
    
}
