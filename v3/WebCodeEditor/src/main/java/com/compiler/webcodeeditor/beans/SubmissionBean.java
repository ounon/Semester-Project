/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package com.compiler.webcodeeditor.beans;


import com.compiler.webcodeeditor.models.Submission;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


@Named(value = "submissionBean")
@SessionScoped
public class SubmissionBean implements Serializable{

    // function to get submissions course (not working)
    public List<Submission> getSubmission(short courseId){
        System.out.println(courseId);
        ClientConfig config = new ClientConfig();
        config.register(new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
        Client restClient = ClientBuilder.newClient(config);
        System.out.println("beforeList");
        List<Submission> submissions = restClient
            .target("http://localhost:8082/submissions/courses/" + courseId)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Submission>> () {});
        System.out.println("submission");
        System.out.println(submissions);
        return submissions;
 
    }
    
}*/
