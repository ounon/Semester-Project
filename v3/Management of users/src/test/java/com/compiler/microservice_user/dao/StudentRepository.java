/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.dao;

import com.compiler.microservice_user.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author User
 */
public interface StudentRepository extends JpaRepository<Student, Short> {
    
}
