package com.example.elhorafi.repositories;


import com.example.elhorafi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
