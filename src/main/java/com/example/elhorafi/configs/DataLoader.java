package com.example.elhorafi.configs;


import com.example.elhorafi.dtos.UserDto;
import com.example.elhorafi.dtos.UserProps;
import com.example.elhorafi.entities.Users;
import com.example.elhorafi.enums.Role;
import com.example.elhorafi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.*;



@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@Slf4j
public class DataLoader {
    private final UserRepository userRepository;
    private final UserProps userProps;

    @Bean
    public ApplicationRunner init(){
        return args -> {
            loadAdmin();
        };
    }

    public void loadAdmin(){
//        Users users = userRepository.findByRole(Role.ROLE_ADMIN);
//        if(users){
//            var user = Users.builder()
//                    .firstName(userProps.getFirstName())
//                    .lastName(userProps.getLastName())
//                    .email(userProps.getEmail())
//                    .password(userProps.getPassword())
//                    .role(userProps.getRole())
//                    .build();
//            userRepository.save(user);
//        }

    }

}
