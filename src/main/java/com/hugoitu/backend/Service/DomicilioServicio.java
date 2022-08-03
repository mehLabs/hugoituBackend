/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Domicilio;
import com.hugoitu.backend.Repository.DomicilioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugos
 */
@Service
public class DomicilioServicio implements IDomicilioServicio{
    
    @Autowired DomicilioRepositorio repo;
    
    @Override
    public Domicilio getDomicilio(){
        return repo.findAll().get(0);
    }
    
    @Override
    public boolean saveDomicilio(Domicilio domicilio){
        
        try{
        repo.save(domicilio);
        return true;
            
        }catch(Error error){ return false;}
    }
    
}
