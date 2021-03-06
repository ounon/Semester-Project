/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.services;

import com.compiler.microservice_user.dao.CourseRepository;
import com.compiler.microservice_user.dao.StudentRepository;
import com.compiler.microservice_user.entities.*;
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
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    // Function to register a student
    @PostMapping(value="/registerStudent")
    public Student register(@RequestBody Student s){
        Student tmpStudent = new Student(s.getFirstName(),s.getLastName(), s.getEmail(), new BCryptPasswordEncoder().encode(s.getPassword()));
        return studentRepository.save(tmpStudent);
    }
    
    // Function to update information relating to a student
    @PutMapping("/students/{student_id}")
    public Student update(@PathVariable(value="student_id") short student_id,@RequestBody Student student){
        student.setStudentId(student_id);
        return studentRepository.save(student);
    }
    
    // Function to assign a course to the student. It takes as parameters the student id and the course id 
    // of the course to be assigned to the student. It also allows you to assign a student to a given course.
    @PostMapping("/students/{student_id}/courses/{course_id}")
    public Student addCourse(@PathVariable(value="student_id") short student_id, @PathVariable(value="course_id") short course_id){
        Student student = studentRepository.getOne(student_id);
        Course course = courseRepository.getOne(course_id);
        student.getCourseList().add(course);
        course.getStudentList().add(student);
        course.setCourseId(course_id);
        courseRepository.save(course);
        student.setStudentId(student_id);
        return studentRepository.save(student);
    }
    
    
    // Function to get the list of all students
    @GetMapping("/students")
    public List<Student> getAll() {
      return studentRepository.findAll();
    }
    
    // Function to get courses for a given student. The student's id is passed in parameter
    @GetMapping("/students/{student_id}/courses")
    public List<Course> getCourses(@PathVariable(value="student_id") short student_id) {
        Student student = studentRepository.getOne(student_id);
        return student.getCourseList();
    }
    
    // Function to get one student. The student's id is passed in parameter
    @GetMapping("/students/{student_id}")
    public Optional<Student> get(@PathVariable(value="student_id") short student_id) {
      return studentRepository.findById(student_id);
    }
    
    // Function to delete one student. The student's id is passed in parameter
    @DeleteMapping("/students/{student_id}")
    public void delete(@PathVariable(value="student_id") short student_id) {
      studentRepository.deleteById(student_id);
    }
    
    // Function to delete all students
    @DeleteMapping("/students")
    public void deleteAll() {
      studentRepository.deleteAll();
    }
    
    // Function to remove course for one student. The student id and the course id of the course to be withdrawn are passed in the parameter
    @DeleteMapping("/students/{student_id}/courses/{course_id}")
    public void removeCourse(@PathVariable(value="student_id") short student_id, @PathVariable(value="course_id") short course_id) {
        Student student = studentRepository.getOne(student_id);
        Course course = courseRepository.getOne(course_id);
        student.getCourseList().remove(course);
        course.getStudentList().remove(student);
        student.setStudentId(student_id);
        studentRepository.save(student);
    }
    
    // function to check password of the student if student
    @GetMapping("/students/{email}/{password}")
    public Student check(@PathVariable(value="email") String email, @PathVariable(value="password") String password)
    {    
        Student student = studentRepository.findByEmail(email);
        if (student != null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
            encoder.matches(password, student.getPassword());
        }
        return student;
    }
    
}