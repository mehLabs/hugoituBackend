/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Educacion;
import com.hugoitu.backend.Repository.EducacionRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugos
 */
@Service
public class EducacionServicio implements IEducacionServicio {
    
    @Autowired EducacionRepositorio repo;
    
    
    @Override
    public List<Educacion> getEducacion(){
        return repo.findAll();
    }
    
    @Override
    public Educacion getEstudio(Long id){
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public boolean saveEducacion(Educacion educacion){
        
        try{
        repo.save(educacion);
        return true;
            
        }catch(Error error){ return false;}
    }
    
    @Override
    public boolean DeleteEducacion(Long id){
        
        try{
        repo.deleteById(id);
        return true;
            
        }catch(Error error){ return false;}
    }
    
}
