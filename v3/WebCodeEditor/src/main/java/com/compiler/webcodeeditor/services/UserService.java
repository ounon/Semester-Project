/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.services;

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
public class UserService {

    /**
     * Creates a new instance of UserService
     */
    public List<Student> getStudents() {
 
        Client restClient = ClientBuilder.newClient();
        List<Student> students = restClient
            .target("http://localhost:8081/students")
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Student>> () {});
        
        System.out.println(students);
        return students;
       
    }
    
}