package com.example.Api1.in28Minutes.Api.services;

import com.example.Api1.in28Minutes.Api.entities.userEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class userService {

    //Creation of static list of users
    private static List<userEntity> users = new ArrayList<>();

    private static Long idCounter = 3L;
    static {
        userEntity userEntity1 = new userEntity(1L, "Tupac", LocalDate.now());
        userEntity userEntity2 = new userEntity(2L, "Alejandro", LocalDate.now());
        userEntity userEntity3 = new userEntity(3L, "Ocampo", LocalDate.now());

        users.add(userEntity1);
        users.add(userEntity2);
        users.add(userEntity3);
    }

    //Service methods
    public List<userEntity> getAllUsers() {
        return users;
    }

    public userEntity findUserById (Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public userEntity saveUser(userEntity user) {
        user.setId(++idCounter);
        users.add(user);
        return user;
    }

    public boolean deleteUserById (Long id) {
        Predicate<? super userEntity> predicate = userEntity -> userEntity.getId().equals(id);
        return users.removeIf(predicate);
    }
}
