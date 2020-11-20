/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.dao.test;

import com.compiler.microservice_question.dao.CourseRepository;
import com.compiler.microservice_question.dao.QuestionRepository;
import com.compiler.microservice_question.dao.StudentRepository;
import com.compiler.microservice_question.entities.Course;
import com.compiler.microservice_question.entities.Question;
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
public class QuestionRepositoryTests {
        @Autowired
        private CourseRepository courseRepository;

        @Autowired
        private StudentRepository studentRepository;

        @Autowired
        private QuestionRepository questionRepository;

        @Test
        public void testQuestion(){
             Question question1 = new Question("Java Ex 1", "Week 1");
        questionRepository.save(question1);
        Question question2 = questionRepository.getOne(question1.getQuestionId());

        assertNotNull(question2);
        assertEquals(question1.getTitle(), question2.getTitle());
        assertEquals(question1.getCategory(), question2.getCategory());
    }
    
   
}
