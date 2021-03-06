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

@RestController
public class AssistantService {
    
    @Autowired
    private AssistantRepository assistantRepository;
    
     @Autowired
    private CourseRepository courseRepository;
    
    // Function to register a assisant
    @PostMapping(value="/assistants")
    public Assistant register(@RequestBody Assistant s){
        Assistant tmpAssistant = new Assistant(s.getFirstName(),s.getLastName(), s.getEmail(), new BCryptPasswordEncoder().encode(s.getPassword()));
        return assistantRepository.save(tmpAssistant);
    }
    
    // Function to assign a course to the assisant. It takes as parameters the assisant id and the course id 
    // of the course to be assigned to the assisant. It also allows you to assign a assisant to a given course.
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
    
    // Function to update information relating to a assisant
    @PutMapping("/assistants/{assistant_id}")
    public Assistant update(@PathVariable(value="assistant_id") short assisant_id,@RequestBody Assistant assistant){
        assistant.setAssistantId(assisant_id);
        return assistantRepository.save(assistant);
    }
    
    // Function to delete all assisants
    @GetMapping("/assistants")
    public List<Assistant> getAll() {
      return assistantRepository.findAll();
    }
    
    // Function to get one assisant. The assisant's id is passed in parameter
    @GetMapping("/assistants/{assistant_id}")
    public Optional<Assistant> get(@PathVariable(value="assistant_id") short assistant_id) {
      return assistantRepository.findById(assistant_id);
    }
    
    // Function to get courses for a given assisant. The assisant's id is passed in parameter
    @GetMapping("/assistants/{assistant_id}/courses")
    public List<Course> getCourses(@PathVariable(value="assistant_id") short assistant_id) {
        Assistant assistant = assistantRepository.getOne(assistant_id);
        return assistant.getCourseList();
    }
    
    // Function to delete one assisant. The assisant's id is passed in parameter
    @DeleteMapping("/assistants/{assistant_id}")
    public void delete(@PathVariable(value="assistant_id") short assistant_id) {
      assistantRepository.deleteById(assistant_id);
    }
    
    // Function to delete all assisants
    @DeleteMapping("/assistants")
    public void deleteAll() {
      assistantRepository.deleteAll();
    }
    
    // function to check password of the assisant if assisant
     @GetMapping("/assistants/{email}/{password}")
    public Assistant check(@PathVariable(value="email") String email, @PathVariable(value="password") String password)
    {
        return assistantRepository.findIfExist(email,password);
    }
}