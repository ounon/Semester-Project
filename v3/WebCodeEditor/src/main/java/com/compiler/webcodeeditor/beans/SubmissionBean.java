/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;


import com.compiler.webcodeeditor.models.Submission;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ISO
 */
@Named(value = "submissionBean")
@SessionScoped
public class SubmissionBean implements Serializable{

   
    public List<Submission> getSubmission(short courseId){
        System.out.println(courseId);
        Client restClient = ClientBuilder.newClient();
        List<Submission> submissions = restClient
            .target("http://localhost:8082/submissions/courses/" + courseId)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Submission>> () {});
        System.out.println("submission");
        System.out.println(submissions);
        return submissions;
        //return new ArrayList();
    }
    
}
