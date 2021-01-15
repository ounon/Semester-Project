/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;

import com.compiler.webcodeeditor.models.Student;
import com.compiler.webcodeeditor.services.UserService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author ISO
 */
@Named
@SessionScoped
public class StudentBean implements Serializable {

    @Inject
    private UserService service;
    
    private List<Student> students;
    
    @PostConstruct
    public void init() {
        System.out.println("aaa");
        students = service.getStudents();
    }

    public List<Student> getStudents() {
        return students;
    }
    
    
    
}
