/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.services;

import com.compiler.microservice_question.dao.QuestionRepository;
import com.compiler.microservice_question.entities.Question;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    
    // Function to add questions 
    @PostMapping(value="/questions")
    public Question add(@RequestBody Question c){
        return questionRepository.save(new Question(c.getTitle(),c.getCategory()));
    }
    
    // Function to get all questions
    @GetMapping("/questions")
    public List<Question> getAll() {
      return questionRepository.findAll();
    }
    
    //Function to get a questions based on id
    @GetMapping("/questions/{question_id}")
    public Optional<Question> get(@PathVariable(value="question_id") short question_id) {
      return questionRepository.findById(question_id);
    }
    
    //Function to delete a questions based on id
    @DeleteMapping("/questions/{question_id}")
    public void delete(@PathVariable(value="question_id") short question_id) {
      questionRepository.deleteById(question_id);
    }
    
    //Function to delete all questions
    @DeleteMapping("/questions")
    public void deleteAll() {
      questionRepository.deleteAll();
    }
    
    //Function to upadte questions based on id
    @PutMapping("/questions/{question_id}")
    public Question update(@PathVariable(value="question_id") short question_id,@RequestBody Question question){
        question.setQuestionId(question_id);
        return questionRepository.save(question);       
    }
    
    
      
}
