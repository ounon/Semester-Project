/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.services;

import com.compiler.microservice_user.dao.StudentRepository;
import com.compiler.microservice_user.entities.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author User
 */
@RestController
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @PostMapping(value="/registerStudent")
    public Student register(@RequestBody Student s){
        Student tmpStudent = new Student(s.getFirstName(),s.getLastName(), s.getEmail(), new BCryptPasswordEncoder().encode(s.getPassword()));
        return studentRepository.save(tmpStudent);
    }
    
    @GetMapping("/students")
    public List<Student> getAll() {
      return studentRepository.findAll();
    }
    
    @GetMapping("/students/{student_id}")
    public Optional<Student> get(@PathVariable(value="student_id") short student_id) {
      return studentRepository.findById(student_id);
    }
    
    @DeleteMapping("/students/{student_id}")
    public void delete(@PathVariable(value="student_id") short student_id) {
      studentRepository.deleteById(student_id);
    }
    
    @DeleteMapping("/students")
    public void deleteAll() {
      studentRepository.deleteAll();
    }
}