/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.models;



import javax.json.bind.annotation.JsonbProperty;



/**
 *
 * @author ISO
 */

public class Submission{
   

    private Question question;
    

    private Student student;

    @JsonbProperty(nillable=true) 
    private int score = 0;
    @JsonbProperty(nillable=true) 
    private String studentSolutionPath = "";

    public Submission() {
    
    }

   
   

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

    public int getScore() {
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
    }
   
}
