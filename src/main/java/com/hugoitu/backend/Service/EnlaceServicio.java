/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Enlace;
import com.hugoitu.backend.Repository.EnlaceRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugos
 */
@Service
public class EnlaceServicio implements IEnlaceServicio {
    
    @Autowired EnlaceRepositorio repo;
    
    @Override
    public List<Enlace> getEnlaces(){
        return repo.findAll();
    }
    
    @Override
    public Enlace getEnlace(Long id){
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public boolean saveEnlace(Enlace enlace){
        
        try{
        repo.save(enlace);
        return true;
            
        }catch(Error error){ return false;}
    }
    
    @Override
    public boolean deleteEnlace(Long id){
        
        try{
        repo.deleteById(id);
        return true;
            
        }catch(Error error){ return false;}
    }
    
}
