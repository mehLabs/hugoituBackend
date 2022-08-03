/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Tecnologia;
import com.hugoitu.backend.Repository.TecnologiaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugos
 */
@Service
public class TecnologiaServicio implements ITecnologiaServicio{

    @Autowired TecnologiaRepositorio repo;
    
    @Override
    public List<Tecnologia> getTecnologias() {
        return repo.findAll();
    }

    @Override
    public Tecnologia getTecnologia(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean saveTecnologia(Tecnologia tecnologia) {
        
        try{
        repo.save(tecnologia);
        return true;
            
        }catch(Error error){ return false;}
    }

    @Override
    public boolean deleteTecnologia(Long id) {
        
        try{
        repo.deleteById(id);
        return true;
            
        }catch(Error error){ return false;}
    }
    
}
