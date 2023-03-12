package com.example.Api1.in28Minutes.Api.repositories;

import com.example.Api1.in28Minutes.Api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

}
