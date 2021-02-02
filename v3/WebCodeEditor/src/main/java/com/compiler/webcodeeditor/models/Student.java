package com.compiler.webcodeeditor.models;

import java.util.List;

public class Student{

    private Short studentId;
   
    private String firstName;
 
    private String lastName;
 
    private String email;

    private String password;

    
    public Student(){
        super();
    }
    
    public Student(Short studentId, String firstName, String lastName, String email, String password)
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

  
    
    
}
