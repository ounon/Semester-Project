/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;

import com.compiler.webcodeeditor.models.Course;

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


@Named
@SessionScoped
public class CourseBean implements Serializable {

    // This function allows you to get the students for a given course based on its Id
    public List<Course> getStudentCourse(short studentId) {
 
        // Call microservice users (getting student's course)
        String url = "http://localhost:8081/students/" + studentId + "/courses";
        Client restClient = ClientBuilder.newClient();
        List<Course> courses = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Course>> () {});
        
        System.out.println(courses);
        return courses;
       
    }
    
    // This function allows you to get the students for a given course based on its Id
    public List<Course> getProfessorCourse(short professorId) {
 
        // Call microservice users (getting professeror's course)
        String url = "http://localhost:8081/professors/" + professorId + "/courses";
        Client restClient = ClientBuilder.newClient();
        List<Course> courses = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Course>> () {});
        
        System.out.println(courses);
        return courses;
       
    }
     
    // This function allows you to get the assistant for a given course based on its Id
    public List<Course> getAssistantCourse(short assistantId) {
 
        // Call microservice users (getting assistants's course)
        String url = "http://localhost:8081/assistants/" + assistantId + "/courses";
        Client restClient = ClientBuilder.newClient();
        List<Course> courses = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Course>> () {});
        
        System.out.println(courses);
        return courses;
       
    }
    
    
    
    
    
}
