/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Experiencia_Laboral;
import com.hugoitu.backend.Repository.ExperienciaLaboralRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugos
 */
@Service
public class ExperienciaLaboralServicio implements IExperienciaLaboralServicio {
    
    @Autowired ExperienciaLaboralRepositorio repo;
    
    @Override
    public List<Experiencia_Laboral> getExperienciasLaborales(){
        return repo.findAll();
    }
    
    @Override
    public Experiencia_Laboral getExperienciaLaboral(Long id){
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public boolean saveExperienciaLaboral(Experiencia_Laboral experienciaLaboral){
        
        try{
        repo.save(experienciaLaboral);
        return true;
            
        }catch(Error error){ return false;}
    }
    
    @Override
    public boolean deleteExperienciaLaboral(Long id){
        try{
        repo.deleteById(id);
        return true;
            
        }catch(Error error){ return false;}
    }
    
}
