/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.services;


import com.compiler.microservice_user.dao.ProfessorRepository;
import com.compiler.microservice_user.entities.Professor;
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
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @PostMapping(value="/registerProfessor")
    public Professor register(@RequestBody Professor s){
        Professor tmpProfessor = new Professor(s.getFirstName(),s.getLastName(), s.getEmail(), new BCryptPasswordEncoder().encode(s.getPassword()));
        return professorRepository.save(tmpProfessor);
    }
    
    @GetMapping("/professors")
    public List<Professor> getAll() {
      return professorRepository.findAll();
    }
    
    @GetMapping("/professors/{professor_id}")
    public Optional<Professor> get(@PathVariable(value="professor_id") short professor_id) {
      return professorRepository.findById(professor_id);
    }
    
    @DeleteMapping("/professors/{professor_id}")
    public void delete(@PathVariable(value="professor_id") short professor_id) {
      professorRepository.deleteById(professor_id);
    }
    
    @DeleteMapping("/professors")
    public void deleteAll() {
      professorRepository.deleteAll();
    }
}