/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.services;

import com.compiler.microservice_question.dao.CourseRepository;
import com.compiler.microservice_question.entities.Course;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author User
 */
@RestController
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    
    @PostMapping(value="/courses")
    public Course add(@RequestBody Course c){
        return courseRepository.save(new Course(c.getName(),c.getDescription()));
    }
    
    @GetMapping("/courses")
    public List<Course> getAll() {
      return courseRepository.findAll();
    }
    
    @GetMapping("/courses/{course_id}")
    public Optional<Course> get(@PathVariable(value="course_id") short course_id) {
      return courseRepository.findById(course_id);
    }
    
    @DeleteMapping("/courses/{course_id}")
    public void delete(@PathVariable(value="course_id") short course_id) {
      courseRepository.deleteById(course_id);
    }
    
    @DeleteMapping("/courses")
    public void deleteAll() {
      courseRepository.deleteAll();
    }
    
  
}
