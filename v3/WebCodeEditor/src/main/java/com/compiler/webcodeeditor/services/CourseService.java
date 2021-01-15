/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.services;

import com.compiler.webcodeeditor.models.Course;
import com.compiler.webcodeeditor.models.Student;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author ISO
 */
@Named  
@ApplicationScoped
public class CourseService {

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
