/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;

import com.compiler.webcodeeditor.models.Assistant;
import com.compiler.webcodeeditor.models.Student;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


@Named
@RequestScoped
public class LoginAssistantBean {

    private String username;

    private String password;
    
    private short id;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Function that is called up when a user logs on.
    public String login() {
        
        // Call microservice to get an assistant based on email and password
        String url = "http://localhost:8081/assistants/" + username + "/" + password;
        Client restClient = ClientBuilder.newClient();
        Assistant assistant = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<Assistant> () {});
        if (assistant != null){
            id = assistant.getAssistantId();
            System.out.println(id);
            return "/studentcourseview.xhtml?faces-redirect=true&includeViewParams=true";
        }
        return "";
    }

}
