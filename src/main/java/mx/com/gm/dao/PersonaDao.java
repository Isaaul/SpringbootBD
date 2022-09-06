/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author isaulgaribaldi
 */
//tener acceso a los metedos 
//antes se ocupaba reposotory

public interface PersonaDao extends CrudRepository<Persona, Long> {


    
}
