package com.example.elhorafi.dtos;

import com.example.elhorafi.enums.Role;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ConfigurationProperties("admin")
@Configuration
public class UserProps {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
