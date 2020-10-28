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
@Table(name = "ASSISTANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assistant.findAll", query = "SELECT a FROM Assistant a"),
    @NamedQuery(name = "Assistant.findByAssistantId", query = "SELECT a FROM Assistant a WHERE a.assistantId = :assistantId"),
    @NamedQuery(name = "Assistant.findByFirstName", query = "SELECT a FROM Assistant a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Assistant.findByLastName", query = "SELECT a FROM Assistant a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Assistant.findByEmail", query = "SELECT a FROM Assistant a WHERE a.email = :email"),
    @NamedQuery(name = "Assistant.findByPassword", query = "SELECT a FROM Assistant a WHERE a.password = :password")})
public class Assistant implements Serializable {

    @JoinTable(name = "ASSISTANT_COURSE", joinColumns = {
        @JoinColumn(name = "ASSISTANT_ID", referencedColumnName = "ASSISTANT_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "COURSE_ID", referencedColumnName = "COURSE_ID")})
    @ManyToMany
    private List<Course> courseList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ASSISTANT_ID")
    private Short assistantId;
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

    public Assistant() {
    }

    public Assistant(Short assistantId) {
        this.assistantId = assistantId;
    }

    public Assistant(Short assistantId, String firstName, String lastName, String email, String password) {
        this.assistantId = assistantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Assistant(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Short getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Short assistantId) {
        this.assistantId = assistantId;
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
        hash += (assistantId != null ? assistantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assistant)) {
            return false;
        }
        Assistant other = (Assistant) object;
        if ((this.assistantId == null && other.assistantId != null) || (this.assistantId != null && !this.assistantId.equals(other.assistantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return assistantId + " - " + firstName + " " + lastName;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    
}
