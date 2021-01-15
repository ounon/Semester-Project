/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;

import com.compiler.webcodeeditor.models.Student;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.primefaces.PrimeFaces;

/**
 *
 * @author ISO
 */
@Named
@RequestScoped
public class LoginBean {

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
        boolean loggedIn = false;

        /*if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
        } else {
            loggedIn = false;
        }*/
        String url = "http://localhost:8081/students/" + username + "/" + password;
        Client restClient = ClientBuilder.newClient();
        Student student = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<Student> () {});
        if (student != null){
            id = student.getStudentId();
            System.out.println(id);
            //return "/AdminPages/AdminMainPage.xhtml?faces-redirect=true&includeViewParams=true";
            return "/studentcourseview.xhtml?faces-redirect=true&includeViewParams=true";
        }
        return "";
    }

}
