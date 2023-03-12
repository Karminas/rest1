package com.example.Api1.in28Minutes.Api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class PostEntity {

    //Attribute
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5)
    private String message;

    @ManyToOne (fetch = FetchType.EAGER)
    @JsonIgnore
    private UserEntity user;

    //Constructor
    public PostEntity() {
    }

    public PostEntity(Long id, String message) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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
