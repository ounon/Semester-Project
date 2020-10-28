/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.services;

import com.compiler.microservice_user.dao.AssistantRepository;
import com.compiler.microservice_user.dao.ProfessorRepository;
import com.compiler.microservice_user.dao.StudentRepository;
import com.compiler.microservice_user.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author User
 */
@RestController
public class UserService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private AssistantRepository assistantRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @PostMapping(value="/listStudents")
    public Student register(@RequestBody Student s){
        Student tmpStudent = new Student(s.getFirstName(),s.getLastName(), s.getEmail(), new BCryptPasswordEncoder().encode(s.getPassword()));
        return studentRepository.save(tmpStudent);
    }
}
