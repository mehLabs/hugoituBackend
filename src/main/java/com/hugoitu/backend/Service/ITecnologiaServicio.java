/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Tecnologia;
import java.util.List;

/**
 *
 * @author hugos
 */
public interface ITecnologiaServicio {
    
    public List<Tecnologia> getTecnologias();
    
    public Tecnologia getTecnologia(Long id);
    
    public boolean saveTecnologia(Tecnologia tecnologia);
    
    public boolean deleteTecnologia(Long id);
    
}
