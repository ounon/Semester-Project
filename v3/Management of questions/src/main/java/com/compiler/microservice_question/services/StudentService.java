/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.services;


import com.compiler.microservice_question.dao.QuestionRepository;
import com.compiler.microservice_question.dao.StudentRepository;
import com.compiler.microservice_question.dao.SubmissionRepository;
import com.compiler.microservice_question.entities.Question;
import com.compiler.microservice_question.entities.Student;
import com.compiler.microservice_question.entities.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ISO
 */
@RestController
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private SubmissionRepository submissionRepository;
    
    // Function to submit one question based on question_id for a given student
    @PostMapping("/students/{student_id}/questions/{question_id}")
    public Student submit(@PathVariable(value="student_id") short student_id, @PathVariable(value="question_id") short question_id){
        Student student = studentRepository.getOne(student_id);
        Question question = questionRepository.getOne(question_id);
        Submission submission = new Submission(student_id,question_id);
        submissionRepository.save(submission);
        question.getSubmissionList().add(submission);
        student.getSubmissionList().add(submission);
        question.setQuestionId(question_id);
        questionRepository.save(question);
        student.setStudentId(student_id);
        return studentRepository.save(student);
    }
}
