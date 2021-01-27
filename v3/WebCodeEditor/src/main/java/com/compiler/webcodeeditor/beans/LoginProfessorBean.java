/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;

import com.compiler.webcodeeditor.models.Professor;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author ISO
 */
@Named
@RequestScoped
public class LoginProfessorBean {

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

    public String login() {
        String url = "http://localhost:8081/professors/" + username + "/" + password;
        Client restClient = ClientBuilder.newClient();
        Professor professor = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<Professor> () {});
        if (professor != null){
            id = professor.getProfessorId();
            System.out.println(id);
            //return "/AdminPages/AdminMainPage.xhtml?faces-redirect=true&includeViewParams=true";
            return "/professorcourseview.xhtml?faces-redirect=true&includeViewParams=true";
        }
        return "";
    }

}
