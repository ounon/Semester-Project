/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.services;

import com.compiler.microservice_user.dao.AssistantRepository;
import com.compiler.microservice_user.dao.CourseRepository;
import com.compiler.microservice_user.dao.ProfessorRepository;
import com.compiler.microservice_user.dao.StudentRepository;
import com.compiler.microservice_user.entities.Assistant;
import com.compiler.microservice_user.entities.Course;
import com.compiler.microservice_user.entities.Professor;
import com.compiler.microservice_user.entities.Student;
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


@RestController
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;
             
    @Autowired
    private AssistantRepository assistantRepository;
    
    // Function to add course
    @PostMapping(value="/courses")
    public Course add(@RequestBody Course c){
        return courseRepository.save(new Course(c.getName(),c.getDescription()));
    }
    
    // Function to assign student to one course. The id of the student to be added and the id of the course passed as a parameter.
    @PostMapping("/courses/{course_id}/students/{student_id}")
    public Course addStudent(@PathVariable(value="course_id") short course_id, @PathVariable(value="student_id") short student_id){
        Student student = studentRepository.getOne(student_id);
        Course course = courseRepository.getOne(course_id);
        student.getCourseList().add(course);
        course.getStudentList().add(student);
        student.setStudentId(student_id);
        studentRepository.save(student);
        course.setCourseId(course_id);
        return courseRepository.save(course);
    }
    
    // Function to assign professor to one course. The id of the professor to be added and the id of the course passed as a parameter.
    @PostMapping("/courses/{course_id}/professors/{professor_id}")
    public Course addProfessor(@PathVariable(value="course_id") short course_id, @PathVariable(value="professor_id") short professor_id){
        Course course = courseRepository.getOne(course_id);
        Professor professor = professorRepository.getOne(professor_id);
        professor.getCourseList().add(course);
        course.getProfessorList().add(professor);
        professor.setProfessorId(professor_id);
        professorRepository.save(professor);
        course.setCourseId(course_id);
        return courseRepository.save(course);
    }
    
    // Function to assign assistant to one course. The id of the assistant to be added and the id of the course passed as a parameter.
    @PostMapping("/courses/{course_id}/assistants/{assistant_id}")
    public Course addAssistant(@PathVariable(value="course_id") short course_id, @PathVariable(value="assistant_id") short assistant_id){
        Assistant assistant = assistantRepository.getOne(assistant_id);
        Course course = courseRepository.getOne(course_id);
        assistant.getCourseList().add(course);
        course.getAssistantList().add(assistant);
        assistant.setAssistantId(assistant_id);
        assistantRepository.save(assistant);
        course.setCourseId(course_id);
        return courseRepository.save(course);
    }
    
    // Function to update course. The id of the course passed as a parameter.
    @PutMapping("/courses/{course_id}")
    public Course update(@PathVariable(value="course_id") short course_id,@RequestBody Course course){
        course.setCourseId(course_id);
        return courseRepository.save(course);
    }
    
    // Function to get all courses
    @GetMapping("/courses")
    public List<Course> getAll() {
      return courseRepository.findAll();
    }
    
    // Function to get course based on the id
    @GetMapping("/courses/{course_id}")
    public Optional<Course> get(@PathVariable(value="course_id") short course_id) {
      return courseRepository.findById(course_id);
    }
    
     // Function to delete course based on the id
    @DeleteMapping("/courses/{course_id}")
    public void delete(@PathVariable(value="course_id") short course_id) {
      courseRepository.deleteById(course_id);
    }
    
    // Function to delete all courses
    @DeleteMapping("/courses")
    public void deleteAll() {
      courseRepository.deleteAll();
    }
    
    
  
}
