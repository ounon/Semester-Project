/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.dao;

import com.compiler.microservice_question.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface QuestionRepository extends JpaRepository<Question, Short>{
    
}
