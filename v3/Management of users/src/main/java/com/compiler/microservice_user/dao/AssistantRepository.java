/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.dao;

import com.compiler.microservice_user.entities.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author User
 */
@RepositoryRestResource
public interface AssistantRepository extends JpaRepository<Assistant, Short> {
    @Query(value = "SELECT * FROM Student s WHERE s.password = :password AND s.email = :email", nativeQuery = true)
    Assistant findIfExist(@Param("email") String email, @Param("password") String password);
}
