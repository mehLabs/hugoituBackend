/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Proyecto;
import java.util.List;

/**
 *
 * @author hugos
 */
public interface IProyectoServicio {
    
    public List<Proyecto> getProyectos();
    
    public Proyecto getProyecto(Long id);
    
    public boolean saveProyecto(Proyecto proyecto);
    
    public boolean deleteProyecto(Long id);
    
}
