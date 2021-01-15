/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.dao;

import com.compiler.microservice_user.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author User
 */

public interface ProfessorRepository extends JpaRepository<Professor, Short>{
    @Query(value = "SELECT * FROM Student s WHERE s.password = :password AND s.email = :email", nativeQuery = true)
    Professor findIfExist(@Param("email") String email, @Param("password") String password);
}
