/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Persona;
import com.hugoitu.backend.Repository.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugos
 */
@Service
public class PersonaServicio implements IPersonaServicio{

    @Autowired PersonaRepositorio repo;
    
    @Override
    public Persona getPersona() {
        return repo.findAll().get(0);
    }

    @Override
    public boolean savePersona(Persona persona) {
        
        try{
        repo.save(persona);
        return true;
            
        }catch(Error error){ return false;}
    }
    
    
    
}
