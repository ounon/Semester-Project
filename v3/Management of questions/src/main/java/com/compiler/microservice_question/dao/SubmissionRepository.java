/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.dao;

import com.compiler.microservice_question.entities.Submission;
import com.compiler.microservice_question.entities.SubmissionPK;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SubmissionRepository extends JpaRepository<Submission, SubmissionPK>{
    
}
