package com.example.elhorafi.controllers;


import com.example.elhorafi.dtos.GenericResponse;
import com.example.elhorafi.dtos.SignInRequest;
import com.example.elhorafi.dtos.UserDto;
import com.example.elhorafi.security.JwtUtil;
import com.example.elhorafi.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/login")
    public String login(@RequestBody UserDto request) {
        System.out.println(request);
        String token = JwtUtil.generateToken(request.getFirstName());
        System.out.println(token);
        return token;
    }
    @PostMapping("/login")
    public ResponseEntity<GenericResponse<Object>> login(@Valid @RequestBody SignInRequest request, HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.OK).body(GenericResponse.success(userService.signIn(request,response),"Login Successfully."));
    }

    @PostMapping("/add")
    public UserDto postUser(@RequestBody UserDto request) {
        return userService.add(request);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.all();
    }

}
