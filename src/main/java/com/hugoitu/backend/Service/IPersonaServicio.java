/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hugoitu.backend.Service;

import com.hugoitu.backend.Model.Persona;

/**
 *
 * @author hugos
 */
public interface IPersonaServicio {
    
    public Persona getPersona();
    
    public boolean savePersona(Persona persona);
    
}
