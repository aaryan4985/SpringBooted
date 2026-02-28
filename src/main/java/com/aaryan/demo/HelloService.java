package com.aaryan.demo;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getMessage() {
        return "Hello Aaryan, Spring Boot with Service Layer!";
    }
}