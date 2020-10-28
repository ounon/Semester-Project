package com.compiler.microservice_user;

import com.compiler.microservice_user.dao.AssistantRepository;
import com.compiler.microservice_user.dao.ProfessorRepository;
import com.compiler.microservice_user.dao.StudentRepository;
import com.compiler.microservice_user.entities.Assistant;
import com.compiler.microservice_user.entities.Professor;
import com.compiler.microservice_user.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceUserApplication implements CommandLineRunner{
    
    @Autowired    
    private StudentRepository studentRepository;
    
    @Autowired    
    private AssistantRepository assistantRepository;
    
    @Autowired    
    private ProfessorRepository professorRepository;
    
    public static void main(String[] args) {
            SpringApplication.run(MicroserviceUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.deleteAll();
        /*studentRepository.save(new Student("Ibrahim","Ounon","ibrahim.ounon@unil.ch","123456"));
        studentRepository.findAll().forEach(s->{
            System.out.println(s.toString());
        });*/
        
        /*assistantRepository.save(new Assistant("Melike","Geçer","melike.geçer@unil.ch","123456"));
        assistantRepository.findAll().forEach(a->{
            System.out.println(a.toString());
        });
        
        professorRepository.save(new Professor("Benoît","Garbinato","Benoit.Garbinato@unil.ch","123456"));
        professorRepository.findAll().forEach(p->{
            System.out.println(p.toString());
        });*/
    }

}
