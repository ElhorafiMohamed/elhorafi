package com.example.elhorafi.services;


import com.example.elhorafi.dtos.UserDto;

import java.util.List;


public interface UserService {
    UserDto add(UserDto d);
    UserDto updated(Long id, UserDto d);
    List<UserDto> all();


}
