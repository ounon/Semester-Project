/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_user.dao.test;

import com.compiler.microservice_user.dao.AssistantRepository;
import com.compiler.microservice_user.entities.Assistant;
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
public class AssistantRepositoryTests {
    @Autowired
    private AssistantRepository assistantRepository;
    
    @Test
    public void testAssistant() {

        Assistant assistant1 = new Assistant("Zabrina", "Hynd", "zhyndh@addthis.com", new BCryptPasswordEncoder().encode("0RSvg2j"));
        assistantRepository.save(assistant1);
        Assistant assistant2 = assistantRepository.getOne(assistant1.getAssistantId());
        assertNotNull(assistant2);
        
        assertEquals(assistant1.getFirstName(), assistant2.getFirstName());
        assertEquals(assistant1.getLastName(), assistant2.getLastName());
        assertEquals(assistant1.getCourseList(), assistant2.getCourseList());
    }
}
