/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author ISO
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
 
    @JsonProperty ("studentId")
    private Short studentId;
    @JsonProperty ("firstName")
    private String firstName;
    @JsonProperty ("lastName")
    private String lastName;
    @JsonProperty ("email")
    private String email;
    @JsonProperty ("password")
    private String password;
    private List<Course> courseList;
    
    public User(){
        super();
    }
    
    public User(Short studentId, String firstName, String lastName, String email, String password)
    {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return studentId + " - " + firstName + " " + lastName;
    }
    
    public short getStudentId(){
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setStudentId(Short studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    
    
}
