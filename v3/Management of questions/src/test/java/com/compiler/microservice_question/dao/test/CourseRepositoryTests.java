/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.dao.test;

import com.compiler.microservice_question.entities.Course;
import com.compiler.microservice_question.dao.CourseRepository;
import com.compiler.microservice_question.dao.QuestionRepository;
import com.compiler.microservice_question.dao.StudentRepository;
import com.compiler.microservice_question.entities.Question;
import com.compiler.microservice_question.entities.Student;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ISO
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class CourseRepositoryTests { 
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    @Test
    public void testCourse() {

        Course course1 = new Course("Architecture Software", "Programming");
        courseRepository.save(course1);
        Course course2 = courseRepository.getOne(course1.getCourseId());
        
        assertNotNull(course2);
        assertEquals(course1.getName(), course2.getName());
        assertEquals(course1.getDescription(), course2.getDescription());
        
        /*Student student = new Student("Axe", "Gunn", "agunn0@weibo.com", "Cyy6lWb3bkf6");
        studentRepository.save(student);
        course1.getStudentList().add(student);
        /*course2.setStudentList(course1.getStudentList());
        
        assertEquals(course1.getStudentList(), course2.getStudentList());
        
        course1.getQuestionList().add(new Question("Question 1", "Week 1"));
        assertEquals(course1.getQuestionList(), course2.getQuestionList());*/
     
    }
}
