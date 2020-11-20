/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.dao.test;

import com.compiler.microservice_user.dao.ProfessorRepository;
import com.compiler.microservice_user.entities.Professor;
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
public class ProfessorRepositoryTests {
 @Autowired
    private ProfessorRepository professorRepository;
    @Test
    public void testProfessor() {

        Professor professor1 = new Professor("Jase", "Ludron", "jludroni@yandex.ru", new BCryptPasswordEncoder().encode("L2RVtzE"));
        professorRepository.save(professor1);
        Professor professor2 = professorRepository.getOne(professor1.getProfessorId());
        assertNotNull(professor2);
        
        assertEquals(professor1.getFirstName(), professor2.getFirstName());
        assertEquals(professor1.getLastName(), professor2.getLastName());
        
        assertEquals(professor1.getCourseList(), professor2.getCourseList());
        
    }
}
