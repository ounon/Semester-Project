/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_id")
    private Short courseId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @JoinTable(name = "professor_course", joinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "professor_id", referencedColumnName = "professor_id")})
    @ManyToMany
    private List<Professor> professorList;
    @JoinTable(name = "assistant_course", joinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "assistant_id", referencedColumnName = "assistant_id")})
    @ManyToMany
    private List<Assistant> assistantList;
    @JoinTable(name = "student_course", joinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "student_id", referencedColumnName = "student_id")})
    @ManyToMany
    private List<Student> studentList;

    public Course() {
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

    @JsonIgnore
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
