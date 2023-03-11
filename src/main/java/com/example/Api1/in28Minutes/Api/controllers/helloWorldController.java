package com.example.Api1.in28Minutes.Api.controllers;

import com.example.Api1.in28Minutes.Api.entities.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/helloWorld")
public class helloWorldController {

    //Return string
    @GetMapping
    public String helloWorld() {
        return "hello World!";
    }

    //Return helloWorld @Bean
    @GetMapping (value="/bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world JSON version");
    }

    //Return helloWorld @Bean with path variable
    @GetMapping (value="/bean/{name}")
    public HelloWorldBean helloWorldBeanWithPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello world JSON version " + name);
    }
}
