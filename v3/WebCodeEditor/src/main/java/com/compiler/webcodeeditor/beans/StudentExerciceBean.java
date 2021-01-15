/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;


import com.compiler.webcodeeditor.models.Question;
import com.compiler.webcodeeditor.models.QuestionFile;
import com.compiler.webcodeeditor.models.ScriptBody;

 
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.primefaces.json.JSONObject;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author ISO
 */
@Named
@RequestScoped
public class StudentExerciceBean {
 
    
    private String OutputText = "";
    //private MenuModel model;

    public String getOutputText() {
        return OutputText;
    }

    public void setOutputText(String OutputText) {
        this.OutputText = OutputText;
    }

    public MenuModel getQuestionsByCategory(short courseId, short studentId) {
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
                item.setHref("studentexerciceview.xhtml");
                item.setParam("studentId", studentId);
                item.setParam("courseId", courseId);
                item.setParam("questionId", question.getQuestionId());
                firstSubmenu.getElements().add(item);
            }

            model.getElements().add(firstSubmenu);
                 
        }
       
        return model;
        
    }

   
    
   public String getExercice(short questionId)
   {
       QuestionFile qf = new QuestionFile();
       String url = "http://localhost:8082/questions/" + questionId;
        Client restClient = ClientBuilder.newClient();
        Question question = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<Question> () {});
        String url2 = question.getQuestionFilePath();
        System.out.println(url2);
        Client restClient2 = ClientBuilder.newClient();
        String response = restClient2
            .target(url2)
            .request(MediaType.TEXT_PLAIN)
            .get(String.class);
        System.out.println(response);
        
        JSONObject obj = new JSONObject(response);
        System.out.println(obj.getString("question"));
      
        return obj.getString("question");
        
   }
   
   public void runCode(String code){
       if (code != null){
           String clientId = "c0932fbc84b9dc0615e212371d9d9189";
       String clientSecret = "c5c4d751552d71830060306dcc76fab1cdb78b14489cfb80afe8e418e26bb19d";
       String script = code;
       String language = "java";
       int versionIndex = 0;
       ScriptBody body = new ScriptBody(clientId, clientSecret, script, language, versionIndex);
       String url = "https://api.jdoodle.com/v1/execute";
       Client restClient = ClientBuilder.newClient();
       String response = restClient
            .target(url).request()
            .post(Entity.json(body), String.class);  
                
        System.out.println(response);
        JSONObject obj = new JSONObject(response);
        System.out.println(obj.getString("output"));
     
        OutputText = obj.getString("output");
       }
       
        
   }
}