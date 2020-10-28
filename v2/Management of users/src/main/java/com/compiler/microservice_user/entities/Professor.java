/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.entities;

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
@Table(name = "PROFESSOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByProfessorId", query = "SELECT p FROM Professor p WHERE p.professorId = :professorId"),
    @NamedQuery(name = "Professor.findByFirstName", query = "SELECT p FROM Professor p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Professor.findByLastName", query = "SELECT p FROM Professor p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Professor.findByEmail", query = "SELECT p FROM Professor p WHERE p.email = :email"),
    @NamedQuery(name = "Professor.findByPassword", query = "SELECT p FROM Professor p WHERE p.password = :password")})
public class Professor implements Serializable {

    @JoinTable(name = "PROFESSOR_COURSE", joinColumns = {
        @JoinColumn(name = "PROFESSOR_ID", referencedColumnName = "PROFESSOR_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "COURSE_ID", referencedColumnName = "COURSE_ID")})
    @ManyToMany
    private List<Course> courseList;

    private static final long serialVersionUID = 1L;
    @Id
       @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "PROFESSOR_ID")
    private Short professorId;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;

    public Professor() {
    }

    public Professor(Short professorId) {
        this.professorId = professorId;
    }

    public Professor(Short professorId, String firstName, String lastName, String email, String password) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Professor(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Short getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Short professorId) {
        this.professorId = professorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (professorId != null ? professorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.professorId == null && other.professorId != null) || (this.professorId != null && !this.professorId.equals(other.professorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return professorId + " - " + firstName + " " + lastName;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    
}
