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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    
    @PostMapping(value="/questions")
    public Question add(@RequestBody Question c){
        return questionRepository.save(new Question(c.getTitle(),c.getCategory()));
    }
    
    @GetMapping("/questions")
    public List<Question> getAll() {
      return questionRepository.findAll();
    }
    
    @GetMapping("/questions/{question_id}")
    public Optional<Question> get(@PathVariable(value="question_id") short question_id) {
      return questionRepository.findById(question_id);
    }
    
    @DeleteMapping("/questions/{question_id}")
    public void delete(@PathVariable(value="question_id") short question_id) {
      questionRepository.deleteById(question_id);
    }
    
    @DeleteMapping("/questions")
    public void deleteAll() {
      questionRepository.deleteAll();
    }
    
    @PutMapping("/questions/{question_id}")
    public Question update(@PathVariable(value="question_id") short question_id,@RequestBody Question question){
        question.setQuestionId(question_id);
        return questionRepository.save(question);       
    }
    
    /*@PutMapping("/questions/{question_id}")
    public Question update(@PathVariable(value="question_id") short question_id,@RequestBody Question question){
        question.setQuestionId(question_id);
        return questionRepository.save(question);     
    }*/
      
}
