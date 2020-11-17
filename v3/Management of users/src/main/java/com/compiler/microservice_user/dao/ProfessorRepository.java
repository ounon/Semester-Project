/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.dao;

import com.compiler.microservice_user.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author User
 */

public interface ProfessorRepository extends JpaRepository<Professor, Short>{
    
}
