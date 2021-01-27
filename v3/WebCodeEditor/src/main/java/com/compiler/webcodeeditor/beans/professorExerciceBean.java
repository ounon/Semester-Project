/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;

import com.compiler.webcodeeditor.models.Question;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author ISO
 */
@Named(value = "professorExerciceBean")
@SessionScoped
public class professorExerciceBean implements Serializable {

    private int questionId;
    
    private int courseId;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    
    
    
    public MenuModel getQuestionsByCategory(short courseId) {
        MenuModel model = new DefaultMenuModel();
        String url = "http://localhost:8082/courses/" + courseId + "/questions";
        Client restClient = ClientBuilder.newClient();
        List<Question> questions = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Question>> () {});
        
        Map<String,List<Question>> questionByCategory = questions.stream()
                          .collect(Collectors.groupingBy(Question::getCategory));
        System.out.println(questionByCategory);
        
        for (Map.Entry<String, List<Question>> entry : questionByCategory.entrySet()) {
            DefaultSubMenu firstSubmenu = new DefaultSubMenu(entry.getKey());
            for (Question question:entry.getValue()){
                DefaultMenuItem item = new DefaultMenuItem(question.getTitle());
                item.setHref("professorsubmissionview.xhtml");
                item.setParam("courseId", courseId);
                item.setParam("questionId", question.getQuestionId());
                firstSubmenu.getElements().add(item);
            }

            model.getElements().add(firstSubmenu);
                 
        }
       
        return model;
        
    }
}
