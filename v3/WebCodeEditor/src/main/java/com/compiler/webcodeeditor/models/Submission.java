/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import javax.json.bind.annotation.JsonbProperty;

/**
 *
 * @author ISO
 */

public class Submission{
   

    private Question question;
    private Student student;

    /*private Integer score = 0;
   
    private String studentSolutionPath = "";*/


    public Submission(Student student, Question question) {
        this.student = student;
        this.question = question;
    }
  
    /*public Submission(Student student, Question question, Integer score, String studentSolutionPath) {
        this.student = student;
        this.question = question;
        if (score == null){
             this.score = 0;
        }
        else{
            this.score = score;
        }
        if (studentSolutionPath == null){
            this.studentSolutionPath = "";
        }
        else{
            this.studentSolutionPath = studentSolutionPath;
        }
        
    }*/

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /* public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStudentSolutionPath() {
        return studentSolutionPath;
    }

    public void setStudentSolutionPath(String studentSolutionPath) {
        this.studentSolutionPath = studentSolutionPath;
    }*/
   
}
