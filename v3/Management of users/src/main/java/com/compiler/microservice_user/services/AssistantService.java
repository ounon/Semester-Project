/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.services;


import com.compiler.microservice_user.dao.AssistantRepository;
import com.compiler.microservice_user.dao.CourseRepository;
import com.compiler.microservice_user.entities.Assistant;
import com.compiler.microservice_user.entities.Course;
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

/**
 *
 * @author User
 */
@RestController
public class AssistantService {
    
    @Autowired
    private AssistantRepository assistantRepository;
    
     @Autowired
    private CourseRepository courseRepository;
    
    @PostMapping(value="/registerAssistant")
    public Assistant register(@RequestBody Assistant s){
        Assistant tmpAssistant = new Assistant(s.getFirstName(),s.getLastName(), s.getEmail(), new BCryptPasswordEncoder().encode(s.getPassword()));
        return assistantRepository.save(tmpAssistant);
    }
    
     @PostMapping("/assistants/{assistant_id}/courses/{course_id}")
    public Assistant addCourse(@PathVariable(value="assistant_id") short assistant_id, @PathVariable(value="course_id") short course_id){
        Assistant assistant = assistantRepository.getOne(assistant_id);
        Course course = courseRepository.getOne(course_id);
        assistant.getCourseList().add(course);
        course.getAssistantList().add(assistant);
        course.setCourseId(course_id);
        courseRepository.save(course);
        assistant.setAssistantId(assistant_id);
        return assistantRepository.save(assistant);
    }
    
    @PutMapping("/assistants/{assistant_id}")
    public Assistant update(@PathVariable(value="assistant_id") short student_id,@RequestBody Assistant assistant){
        assistant.setAssistantId(student_id);
        return assistantRepository.save(assistant);
    }
    @GetMapping("/assistants")
    public List<Assistant> getAll() {
      return assistantRepository.findAll();
    }
    
    @GetMapping("/assistants/{assistant_id}")
    public Optional<Assistant> get(@PathVariable(value="assistant_id") short assistant_id) {
      return assistantRepository.findById(assistant_id);
    }
    
     @GetMapping("/assistants/{assistant_id}/courses")
    public List<Course> getCourses(@PathVariable(value="professor_id") short student_id) {
        Assistant assistant = assistantRepository.getOne(student_id);
        return assistant.getCourseList();
    }
    
    @DeleteMapping("/assistants/{assistant_id}")
    public void delete(@PathVariable(value="assistant_id") short assistant_id) {
      assistantRepository.deleteById(assistant_id);
    }
    
    @DeleteMapping("/assistants")
    public void deleteAll() {
      assistantRepository.deleteAll();
    }
}