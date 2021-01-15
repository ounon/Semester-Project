package com.compiler.webcodeeditor.models;


import java.io.Serializable;
import java.util.List;

public class Student implements Serializable{
 
    //@JsonProperty ("studentId")
    private Short studentId;
    //@JsonProperty ("firstName")
    private String firstName;
    //@JsonProperty ("lastName")
    private String lastName;
    //@JsonProperty ("email")
    private String email;
    //@JsonProperty ("password")
    private String password;
    //private List<Course> courseList;
    
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

    /*public List<Course> getCourseList() {
        return courseList;
    }*/

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

   /* public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }*/
    
    
}
