package com.example.elhorafi.controllers;


import com.example.elhorafi.dtos.UserDto;
import com.example.elhorafi.services.UserService;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/add")
    public UserDto postUser(@RequestBody UserDto request) {
        return userService.add(request);
    }

    @GetMapping
    public List<UserDto> getAll(){
        return userService.all();
    }

}
