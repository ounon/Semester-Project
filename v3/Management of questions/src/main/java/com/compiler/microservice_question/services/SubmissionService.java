/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.services;

import com.compiler.microservice_question.dao.CourseRepository;
import com.compiler.microservice_question.dao.QuestionRepository;
import com.compiler.microservice_question.dao.StudentRepository;
import com.compiler.microservice_question.dao.SubmissionRepository;
import com.compiler.microservice_question.entities.Course;
import com.compiler.microservice_question.entities.Question;
import com.compiler.microservice_question.entities.Submission;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ISO
 */
@RestController
public class SubmissionService {
    
    @Autowired
    private SubmissionRepository submissionRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    
    // Function to get all submission for one course based on course id 
    @GetMapping("/submissions/courses/{course_id}")
    public List<Submission> submit(@PathVariable(value="course_id") short course_id){
        Course course = courseRepository.getOne(course_id); 
        List<Question> questions = course.getQuestionList();
        List<Submission> submissionTmp = submissionRepository.findAll();
        List<Submission> submissions = new ArrayList();
        for (Submission s: submissionTmp)
        {
                for (Question q: questions){
                    if (q.getQuestionId() == s.getQuestion().getQuestionId())
                    {
                        submissions.add(s);
                    }
            }
        }
        return submissions;
       
    }
    
}
