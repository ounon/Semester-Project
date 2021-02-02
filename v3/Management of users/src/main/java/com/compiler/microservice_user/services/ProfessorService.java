/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.services;


import com.compiler.microservice_user.dao.CourseRepository;
import com.compiler.microservice_user.dao.ProfessorRepository;
import com.compiler.microservice_user.entities.Course;
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
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    // Function to register a professor
    @PostMapping(value="/professors")
    public Professor register(@RequestBody Professor s){
        Professor tmpProfessor = new Professor(s.getFirstName(),s.getLastName(), s.getEmail(), new BCryptPasswordEncoder().encode(s.getPassword()));
        return professorRepository.save(tmpProfessor);
    }
    
    // Function to assign a course to the professor. It takes as parameters the professor id and the course id 
    // of the course to be assigned to the professor. It also allows you to assign a professor to a given course.
    @PostMapping("/professors/{professor_id}/courses/{course_id}")
    public Professor addCourse(@PathVariable(value="professor_id") short professor_id, @PathVariable(value="course_id") short course_id){
        Professor professor = professorRepository.getOne(professor_id);
        Course course = courseRepository.getOne(course_id);
        professor.getCourseList().add(course);
        course.getProfessorList().add(professor);
        course.setCourseId(course_id);
        courseRepository.save(course);
        professor.setProfessorId(professor_id);
        return professorRepository.save(professor);
    }
    
    // Function to update information relating to a professor
    @PutMapping("/professors/{professor_id}")
    public Professor update(@PathVariable(value="professor_id") short professor_id,@RequestBody Professor professor){
        professor.setProfessorId(professor_id);
        return professorRepository.save(professor);
    }
    
    // Function to get the list of all professors
    @GetMapping("/professors")
    public List<Professor> getAll() {
      return professorRepository.findAll();
    }
    
    // Function to get courses for a given professor. The professor's id is passed in parameter
    @GetMapping("/professors/{professor_id}")
    public Optional<Professor> get(@PathVariable(value="professor_id") short professor_id) {
      return professorRepository.findById(professor_id);
    }
    
    // Function to get courses for a given professor. The professor's id is passed in parameter
    @GetMapping("/professors/{professor_id}/courses")
    public List<Course> getCourses(@PathVariable(value="professor_id") short professor_id) {
        Professor professor = professorRepository.getOne(professor_id);
        return professor.getCourseList();
    }
    
    // Function to delete one professor. The professor's id is passed in parameter
    @DeleteMapping("/professors/{professor_id}")
    public void delete(@PathVariable(value="professor_id") short professor_id) {
      professorRepository.deleteById(professor_id);
    }
    
    // Function to delete all professors
    @DeleteMapping("/professors")
    public void deleteAll() {
      professorRepository.deleteAll();
    }
    
    // function to check password of the professor if professor
    @GetMapping("/professors/{email}/{password}")
    public Professor check(@PathVariable(value="email") String email, @PathVariable(value="password") String password)
    {
        Professor professor = professorRepository.findByEmail(email);
        if (professor != null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
            encoder.matches(password, professor.getPassword());
        }
        return professor;
    }
}