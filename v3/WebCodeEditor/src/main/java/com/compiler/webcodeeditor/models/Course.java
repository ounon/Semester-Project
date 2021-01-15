/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.models;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author User
 */

public class Course implements Serializable {

    private Short courseId;
    
    private String name;
   
    private String description;
  
    //private List<Professor> professorList;
   
    //private List<Assistant> assistantList;
   
    //private List<Student> studentList;

    public Course() {
    }

    public Course(Short courseId, String name, String description) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
    }

    
    public Course(Short courseId) {
        this.courseId = courseId;
    }

    public Course(Short courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }
    
    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Short getCourseId() {
        return courseId;
    }

    public void setCourseId(Short courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*@JsonIgnore
    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    @JsonIgnore
    public List<Assistant> getAssistantList() {
        return assistantList;
    }

    public void setAssistantList(List<Assistant> assistantList) {
        this.assistantList = assistantList;
    }

    @JsonIgnore
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.compiler.microservice_user.entities.Course[ courseId=" + courseId + " ]";
    }
    
}
