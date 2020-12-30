/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.controller;


import com.compiler.Models.User;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ISO
 */
 
@Controller
@RequestMapping("/compiler")
public class AppController {
    @GetMapping("/user")
    public String listUser(Model model) {
         
        RestTemplate restTemplate = new RestTemplate();
       /* UserList userList = restTemplate.getForObject(
            "http://localhost:8080/students",
             UserList.class
        );
        User[] list = restTemplate.getForObject("http://localhost:8080/students", User[].class);
        
 
        if (list != null) {
            for (User e : list) {
                System.out.println("User: " + e);
            }
        }*/
        ResponseEntity<List<User>> response = restTemplate.exchange(
        "http://localhost:8080/students/",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<User>>(){});
        List<User> users = response.getBody();
        System.out.println(users);
        for (User e : users) {
                System.out.println("User: " + e);
            }
       
        model.addAttribute("users", users);
        
       /*  ResponseEntity<User[]> entity = restTemplate.getForEntity("http://localhost:8080/assistants/",
                                                                User[].class);
        if (entity.getBody() != null)
            
        {
            List<User> users = entity.getBody();
            System.out.println("b" + Arrays.asList(entity.getBody()));
        }
        else{
            System.out.println("a" + Collections.emptyList());
        }*/
                                   
       
        /*HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity < String > entity = new HttpEntity <String> ("parameters", headers);

        ResponseEntity < String > result = restTemplate.exchange("http://localhost:8080/students", HttpMethod.GET, entity,
                String.class);

        model.addAttribute("users", result);
        System.out.println(result);*/
         
        return "user";
    }
}
