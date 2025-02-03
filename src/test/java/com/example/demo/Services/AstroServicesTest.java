package com.example.demo.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServicesTest {

    @Autowired
    AstroServices services;

    @Test
    void getPeopleInSpace() {
        String people = services.getPeopleInSpace();
        assertTrue(people.contains("people"));
        System.out.println(people);
    }

    @Test
    void getAstroResponse() {
        var response = services.getAstroResponse();
        assertEquals("success",response.message());
        assertTrue(response.number()>=0);
        assertEquals(response.people().size(),response.number());
        System.out.println(response);


    }
}