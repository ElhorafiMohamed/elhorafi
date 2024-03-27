package com.example.elhorafi.services;

import com.example.elhorafi.dtos.SignInRequest;
import com.example.elhorafi.dtos.UserDto;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface UserService {
    UserDto add(UserDto d);
    UserDto updated(Long id, UserDto d);
    List<UserDto> all();

    Object signIn(SignInRequest request, HttpServletResponse response);
}
