package com.compiler.webcodeeditor.models;


import java.io.Serializable;


public class Professor implements Serializable{
 

    private Short professorId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    
    public Professor(){
        super();
    }
    
    public Professor(Short professorId, String firstName, String lastName, String email, String password)
    {
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return professorId + " - " + firstName + " " + lastName;
    }
    
    public short getProfessorId(){
        return professorId;
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

    /*public List<Course> getCourseList() {
        return courseList;
    }*/

    public void setProfessorId(Short professorId) {
        this.professorId = professorId;
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
