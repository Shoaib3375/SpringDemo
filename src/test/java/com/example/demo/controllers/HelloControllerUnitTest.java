package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerUnitTest {

    @Test
    void sayHello() {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("Shoaib",model);
        assertAll(
                ()->assertEquals("welcome",result),
                ()->assertEquals("Shoaib",model.getAttribute("user"))
        );
//        assertEquals("welcome", result);
//        assertEquals("Shoaib",model.getAttribute("user"));
    }
}