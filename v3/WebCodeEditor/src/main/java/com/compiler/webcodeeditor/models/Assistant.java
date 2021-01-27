package com.compiler.webcodeeditor.models;


import java.io.Serializable;
import java.util.List;

public class Assistant implements Serializable{
 
    //@JsonProperty ("assistantId")
    private Short assistantId;
    //@JsonProperty ("firstName")
    private String firstName;
    //@JsonProperty ("lastName")
    private String lastName;
    //@JsonProperty ("email")
    private String email;
    //@JsonProperty ("password")
    private String password;
    //private List<Course> courseList;
    
    public Assistant(){
        super();
    }
    
    public Assistant(Short assistantId, String firstName, String lastName, String email, String password)
    {
        this.assistantId = assistantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return assistantId + " - " + firstName + " " + lastName;
    }
    
    public short getAssistantId(){
        return assistantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setAssistantId(Short assistantId) {
        this.assistantId = assistantId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    
    
}
