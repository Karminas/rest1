package com.example.Api1.in28Minutes.Api.entities;

public class postEntity {

    //Attribute
    private Long id;
    private String message;

    //Constructor
    public postEntity() {
    }

    public postEntity(Long id, String message) {
        this.id = id;
        this.message = message;
    }
    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //To string
    @Override
    public String toString() {
        return "postEntity{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
