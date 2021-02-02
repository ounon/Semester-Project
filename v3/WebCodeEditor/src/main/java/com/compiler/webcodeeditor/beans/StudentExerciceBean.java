/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.beans;


import com.compiler.webcodeeditor.models.Question;
import com.compiler.webcodeeditor.models.QuestionFile;
import com.compiler.webcodeeditor.models.ScriptBody;
import java.io.Serializable;

 
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
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


@Named
@SessionScoped
public class StudentExerciceBean implements Serializable {
 
    
    private String OutputText = "";
    //private MenuModel model;
    
    private String inputText;
    
    private int questionId;
    
    private int courseId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    
    

    public String getOutputText() {
        return OutputText;
    }

    public void setOutputText(String OutputText) {
        this.OutputText = OutputText;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    
    
    @PostConstruct
    public void init(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
        .getRequest();
        String id = request.getParameter("questionId");
        if (id != null)
        {
            inputText = getExercice((short)questionId);
        }
        //System.out.println("HEY");
        System.out.println(id);
        
        System.out.println("inputtext " + inputText);
        OutputText = "";
    }

    
    // Function to create a left Menu. This menu displays the questions by categories 
    // The view menu is for a student and a given course. 
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

   
    
   // Function to retrieve an exercise: The retrieved exercise will be displayed in the student exercise view page.
   public String getExercice(short questionId)
   {
       OutputText = "";
       QuestionFile qf = new QuestionFile();
       //Getting an exercice for a question given
       String url = "http://localhost:8082/questions/" + questionId;
       System.out.println("HELLO");
       System.out.println(url);
        Client restClient = ClientBuilder.newClient();
        Question question = restClient
            .target(url)
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<Question> () {});
        
        // Get url of question in the response of the requeste above
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

   // Function to call jdoodle api api and get result
   public void runCode(){
       
       System.out.println("inputText " + inputText);
       
        //inputText = getExercice((short)questionId);
        // acces for connecting to jdoodle
        String clientId = "c0932fbc84b9dc0615e212371d9d9189";
        String clientSecret = "c5c4d751552d71830060306dcc76fab1cdb78b14489cfb80afe8e418e26bb19d";
        String script = getExercice((short)questionId);
        //String script = "public class HelloWorld{ \\n public static void main(String []args){ \\n int[] numbers = {12, 23, 34, 45, 56, 67, 78, 89, 90}; \\n printElemenets(numbers); } \\n // Write the method here \\n }";
        String language = "java";
        int versionIndex = 0;
        
        // Serializing the body of jdoodle api
        ScriptBody body = new ScriptBody(clientId, clientSecret, inputText, language, versionIndex);
        
        // Execute jdoodle api
        String url = "https://api.jdoodle.com/v1/execute";
        Client restClient = ClientBuilder.newClient();
        String response = restClient
             .target(url).request()
             .post(Entity.json(body), String.class);  

         System.out.println(response);
         JSONObject obj = new JSONObject(response);
         System.out.println(obj.getString("output"));

         OutputText = obj.getString("output") != null ? obj.getString("output") :  "null";
         System.out.println(script);
        
       
        
   }
}