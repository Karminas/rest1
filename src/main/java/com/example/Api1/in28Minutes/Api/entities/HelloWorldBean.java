package com.example.Api1.in28Minutes.Api.entities;

public class HelloWorldBean {

    public HelloWorldBean() {
    }

    public HelloWorldBean(String message) {
        this.message = message;
    }

    private String message;

    //Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //To string
    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

}
