/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;

import com.compiler.webcodeeditor.models.Course;
import com.compiler.webcodeeditor.services.CourseService;
import com.compiler.webcodeeditor.services.UserService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ISO
 */
@Named
@SessionScoped
public class CourseBean implements Serializable {

   
    //private CourseService service;
    
    //private List<Course> courses;
    
    /*@PostConstruct
    public void init() {
        System.out.println("aaa");
        courses = service.getStudentCourse((short)1);
    }

    public List<Course> getCourses() {
        return courses;
    }*/
    
    public List<Course> getStudentCourse(short studentId) {
 
        String url = "http://localhost:8081/students/" + studentId + "/courses";
        Client restClient = ClientBuilder.newClient();
        List<Course> courses = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Course>> () {});
        
        System.out.println(courses);
        return courses;
       
    }
    
    
    
    
    
}
