package com.example.elhorafi.services;

import com.example.elhorafi.dtos.UserDto;

import com.example.elhorafi.entities.Users;
import com.example.elhorafi.enums.Role;
import com.example.elhorafi.mappers.UserMapper;
import com.example.elhorafi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDto add(UserDto d) {
        //System.out.println(passwordEncoder.encode(d.getPassword()));
        //d.setPassword(passwordEncoder(d.getPassword()));
        return userMapper.mapToDto(userRepository.save(userMapper.mapToEntity(d)));
    }

    @Override
    public UserDto updated(Long id, UserDto d) {
        return userMapper.mapToDto(userRepository.save(userMapper.mapToEntity(d)));
    }

    @Override
    public List<UserDto> all() {
        return userMapper.mapToDtoList(
                userRepository.findAll());
    }

    @Override
    public Users loadUserByUsername(String email) {
        UserDto user =  userMapper.mapToDto(
               userRepository.findByEmailIgnoreCase(email));
        Users userDetails =
                Users.builder()
                        .firstName(user.getEmail())
                        .password(user.getPassword())
                        .role(Role.ROLE_ADMIN)
                        .build();
        return userDetails;
    }


}
