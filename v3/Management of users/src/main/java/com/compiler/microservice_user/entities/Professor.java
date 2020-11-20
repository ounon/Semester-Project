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
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByProfessorId", query = "SELECT p FROM Professor p WHERE p.professorId = :professorId"),
    @NamedQuery(name = "Professor.findByFirstName", query = "SELECT p FROM Professor p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Professor.findByLastName", query = "SELECT p FROM Professor p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Professor.findByEmail", query = "SELECT p FROM Professor p WHERE p.email = :email"),
    @NamedQuery(name = "Professor.findByPassword", query = "SELECT p FROM Professor p WHERE p.password = :password")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "professor_id")
    private Short professorId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @ManyToMany(mappedBy = "professorList")
    private List<Course> courseList;

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

    @JsonIgnore
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
        return "com.compiler.microservice_user.entities.Professor[ professorId=" + professorId + " ]";
    }
    
}
