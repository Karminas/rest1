package com.example.Api1.in28Minutes.Api.controllers;

import com.example.Api1.in28Minutes.Api.entities.PostEntity;
import com.example.Api1.in28Minutes.Api.entities.UserEntity;
import com.example.Api1.in28Minutes.Api.exceptions.resourceNotFoundException;
import com.example.Api1.in28Minutes.Api.services.userService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping (value = "v1/users")
public class userController {

    //Services
    private final userService userservice;

    //Constructor
    public userController(userService userservice) {
        this.userservice = userservice;
    }

    //Methods
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userservice.getAllUsers();
    }

    @GetMapping (value = "{id}")
    public EntityModel<UserEntity> getUserById(@PathVariable Long id) {
        UserEntity foundUser =  userservice.findUserById(id);

        if (foundUser == null) {
            throw new resourceNotFoundException("User was not found");
        }
        else {
            EntityModel<UserEntity> entityModel = EntityModel.of(foundUser);
            WebMvcLinkBuilder link =  WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllUsers());
            entityModel.add(link.withRel("all-users"));
            return entityModel;
        }
    }

    @PostMapping
    public ResponseEntity<UserEntity> addNewUser (@Valid @RequestBody UserEntity user) {
        UserEntity savedUser =  userservice.saveUser(user);
        if (savedUser != null){
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedUser.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping (value = "/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody @Valid UserEntity user) {
        userservice.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = "{id}")
    public ResponseEntity<UserEntity> deleteUserById (@PathVariable Long id) {
        userservice.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}/posts")
    public List<PostEntity> getAllUserPosts (@PathVariable Long id) {
        return userservice.getAllUserPosts(id);
    }
}
