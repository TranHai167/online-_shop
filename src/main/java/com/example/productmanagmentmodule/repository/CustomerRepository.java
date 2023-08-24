package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.UserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<UserIdentity, Integer> {
}
