package com.example.demo;

import com.example.demo.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    ExampleService service;


    @Test
    void contextLoads() {
        service.saveBatch();
    }

}
