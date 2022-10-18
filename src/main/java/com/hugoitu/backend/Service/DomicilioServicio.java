/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Domicilio;
import com.hugoitu.backend.Repository.DomicilioRepositorio;
import java.util.List;
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
        List<Domicilio> domicilios = repo.findAll();
        return !domicilios.isEmpty() ? domicilios.get(0) : new Domicilio();
    }
    
    @Override
    public boolean saveDomicilio(Domicilio domicilio){
        
        try{
        repo.save(domicilio);
        return true;
            
        }catch(Error error){ return false;}
    }
    
}
