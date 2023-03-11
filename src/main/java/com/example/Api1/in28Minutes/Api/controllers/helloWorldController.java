package com.example.Api1.in28Minutes.Api.controllers;

import com.example.Api1.in28Minutes.Api.entities.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping (value = "/helloWorld")
public class helloWorldController {

    //Resources
    private final MessageSource messageSource;

    //Constructor
    public helloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //Return string
    @GetMapping
    public String helloWorld() {
        return "hello World!";
    }

    @GetMapping (value="/international")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
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
