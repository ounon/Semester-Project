/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.dao.test;

import com.compiler.microservice_user.dao.StudentRepository;
import com.compiler.microservice_user.entities.Student;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author User
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTests {
 @Autowired
    private StudentRepository studentRepository;
    @Test
    public void testStudent() {

        Student student1 = new Student("Mariska", "Esome", "mesomej@nationalgeographic.com", new BCryptPasswordEncoder().encode("Rn9hXMMp"));
        studentRepository.save(student1);
        Student student2 = studentRepository.getOne(student1.getStudentId());
        assertNotNull(student2);
        
        assertEquals(student1.getFirstName(), student2.getFirstName());
        assertEquals(student1.getLastName(), student2.getLastName());
        assertEquals(student1.getCourseList(), student2.getCourseList());
        
    }
}
