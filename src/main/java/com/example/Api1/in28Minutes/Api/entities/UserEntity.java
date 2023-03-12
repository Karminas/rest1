package com.example.Api1.in28Minutes.Api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
public class UserEntity {

    //Attributes
    @Id
    @JsonIgnore
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Name should have at least 2 characters in length.")
    private String name;

    @Past (message = "Birthday cannot be from future dates.")
    private LocalDate birthdate;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostEntity> posts;

    //Constructors
    public UserEntity() {
    }
    
    public UserEntity(Long id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }

    //ToString
    @Override
    public String toString() {
        return "userEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
