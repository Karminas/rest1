package com.example.Api1.in28Minutes.Api.controllers;

import com.example.Api1.in28Minutes.Api.entities.userEntity;
import com.example.Api1.in28Minutes.Api.exceptions.resourceNotFoundException;
import com.example.Api1.in28Minutes.Api.services.userService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public List<userEntity> getAllUsers() {
        return userservice.getAllUsers();
    }

    @GetMapping (value = "{id}")
    public userEntity getUserById(@PathVariable Long id) {
        userEntity foundUser =  userservice.findUserById(id);
        if (foundUser == null) {
            throw new resourceNotFoundException("User was not found");
        }
        else {return foundUser;}
    }

    @PostMapping
    public ResponseEntity<userEntity> addNewUser (@Valid @RequestBody userEntity user) {
        userEntity savedUser =  userservice.saveUser(user);
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
    public ResponseEntity<userEntity> updateUser(@PathVariable Long id, @RequestBody @Valid userEntity user) {
        if (userservice.updateUser(id, user)) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping (value = "{id}")
    public ResponseEntity<userEntity> deleteUserById (@PathVariable Long id) {
        if (userservice.deleteUserById(id)) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
