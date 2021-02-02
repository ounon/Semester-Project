/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.services;

import com.compiler.microservice_question.dao.CourseRepository;
import com.compiler.microservice_question.dao.QuestionRepository;
import com.compiler.microservice_question.entities.Course;
import com.compiler.microservice_question.entities.Question;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private QuestionRepository  questionRepository;
    
    @PostMapping(value="/courses")
    public Course add(@RequestBody Course c){
        return courseRepository.save(new Course(c.getName(),c.getDescription()));
    }
    
    // Function to get all courses
    @GetMapping("/courses")
    public List<Course> getAll() {
      return courseRepository.findAll();
    }
    
    // Function to get course based on id
    @GetMapping("/courses/{course_id}")
    public Optional<Course> get(@PathVariable(value="course_id") short course_id) {
      return courseRepository.findById(course_id);
    }
    
    // Function to delete course based on id
    @DeleteMapping("/courses/{course_id}")
    public void delete(@PathVariable(value="course_id") short course_id) {
      courseRepository.deleteById(course_id);
    }
    
    // Function to delete all courses 
    @DeleteMapping("/courses")
    public void deleteAll() {
      courseRepository.deleteAll();
    }
    
    // Function to assign question to a course. The id of course and id of question are passed in parameters
    @PostMapping("/courses/{course_id}/questions/{question_id}")
    public Course addQuestion(@PathVariable(value="course_id") short course_id, @PathVariable(value="question_id") short question_id){
        Question question = questionRepository.getOne(question_id);
        Course course = courseRepository.getOne(course_id);
        question.getCourseList().add(course);
        course.getQuestionList().add(question);
        question.setQuestionId(question_id);
        questionRepository.save(question);
        course.setCourseId(course_id);
        return courseRepository.save(course);
    }
    
    // Function to get all question for a given course
    @GetMapping("/courses/{course_id}/questions")
    public List<Question> getQuestions(@PathVariable(value="course_id") short course_id){
        Course course = courseRepository.getOne(course_id); 
        return course.getQuestionList();
    }
  
}
