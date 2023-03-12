package com.example.Api1.in28Minutes.Api.services;

import com.example.Api1.in28Minutes.Api.entities.PostEntity;
import com.example.Api1.in28Minutes.Api.entities.UserEntity;
import com.example.Api1.in28Minutes.Api.repositories.PostRepository;
import com.example.Api1.in28Minutes.Api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class userService {

    //Repositories
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //Constructor
    public userService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    //Service methods
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findUserById (Long id) {
        // Create custom exceptions
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void updateUser (Long id, UserEntity user) {
        //Missing: Throw exception
        UserEntity foundUser = userRepository.findById(id).orElse(null);
        foundUser.setName(user.getName());
        foundUser.setBirthdate(user.getBirthdate());

        userRepository.deleteById(id);
        userRepository.save(foundUser);
    }

    public void deleteUserById (Long id) {
        //Missing: Throw exception
        userRepository.findById(id).orElse(null);
        userRepository.deleteById(id);
    }

    public List<PostEntity> getAllUserPosts (Long id) {
        return userRepository.findById(id).get().getPosts();
    }
}
