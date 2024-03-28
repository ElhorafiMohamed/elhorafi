package com.example.elhorafi.controllers;


import com.example.elhorafi.dtos.UserDto;
import com.example.elhorafi.entities.Users;
import com.example.elhorafi.services.UserService;
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


    @PostMapping("/add")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
            userService.add(userDto);
            return ResponseEntity.ok(userDto);
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return userService.all();
    }

    @GetMapping("/email")
    public Users loadUserByUsername(RequestBody UserDto) {
        System.out.println(UserDto);
        return userService.loadUserByUsername("mohamed@gmail.com");
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody UserDto request) {
        System.out.println(request);
    }

}
