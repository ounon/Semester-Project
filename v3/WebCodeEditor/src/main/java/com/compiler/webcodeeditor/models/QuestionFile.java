/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.models;

import java.io.Serializable;

/**
 *
 * @author ISO
 */
public class QuestionFile implements Serializable {
    String description;
    String question;
    String solution;
    String programming_language;
    int total_score;
    Object test_cases;
    
    public QuestionFile(){
        
    }

    public QuestionFile(String description, String question, String solution, String programmingLanguage) {
        this.description = description;
        this.question = question;
        this.solution = solution;
        this.programming_language = programmingLanguage;
    }

    public QuestionFile(String description, String question) {
        this.description = description;
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getProgrammingLanguage() {
        return programming_language;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programming_language = programmingLanguage;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public Object getTest_cases() {
        return test_cases;
    }

    public void setTest_cases(String test_cases) {
        this.test_cases = test_cases;
    }
    
    
}
