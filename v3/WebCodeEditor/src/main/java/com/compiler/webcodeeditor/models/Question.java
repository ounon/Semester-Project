/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.models;

import java.io.Serializable;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author User
 */

public class Question implements Serializable {

    private Short questionId;
    
    private String title;
   
    private String questionFilePath;
    
    private String questionType;
  
    private String category;

    public Question() {
    }

    public Question(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Short getQuestionId() {
        return questionId;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestionFilePath() {
        return questionFilePath;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getCategory() {
        return category;
    }

    public void setQuestionId(Short questionId) {
        this.questionId = questionId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestionFilePath(String questionFilePath) {
        this.questionFilePath = questionFilePath;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    

}

