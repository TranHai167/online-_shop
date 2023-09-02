package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findUserEntityByEmailAndPassword(String email, String password);
    UserEntity findFirstByEmail(String email);

    UserEntity findFirstById(String id);
}

