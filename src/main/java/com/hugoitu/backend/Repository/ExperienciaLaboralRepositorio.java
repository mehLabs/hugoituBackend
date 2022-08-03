/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Repository;

import com.hugoitu.backend.Model.Experiencia_Laboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hugos
 */
@Repository
public interface ExperienciaLaboralRepositorio extends JpaRepository<Experiencia_Laboral,Long>{
    
}
