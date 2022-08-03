/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Proyecto;
import com.hugoitu.backend.Repository.ProyectoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugos
 */
@Service
public class ProyectoServicio implements IProyectoServicio{

    @Autowired ProyectoRepositorio repo;
    
    @Override
    public List<Proyecto> getProyectos() {
        return repo.findAll();
    }

    @Override
    public Proyecto getProyecto(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean saveProyecto(Proyecto proyecto) {
        
        try{
        repo.save(proyecto);
        return true;
            
        }catch(Error error){ return false;}
    }

    @Override
    public boolean deleteProyecto(Long id) {
        
        try{
        repo.deleteById(id);
        return true;
            
        }catch(Error error){ return false;}
    }
    
}
