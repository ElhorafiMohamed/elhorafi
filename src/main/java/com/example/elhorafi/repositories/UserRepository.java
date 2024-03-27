package com.example.elhorafi.repositories;


import com.example.elhorafi.entities.Users;
import com.example.elhorafi.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmailIgnoreCase(String email);
    Users findByRole(Role role);

}
