/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Enlace;
import java.util.List;

/**
 *
 * @author hugos
 */
public interface IEnlaceServicio {
    
    public List<Enlace> getEnlaces();
    
    public Enlace getEnlace(Long id);
    
    public boolean saveEnlace(Enlace enlace);
    
    public boolean deleteEnlace(Long id);
    
}
