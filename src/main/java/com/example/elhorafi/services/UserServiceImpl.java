package com.example.elhorafi.services;

import com.example.elhorafi.dtos.JwtAuthenticationResponse;
import com.example.elhorafi.dtos.SignInRequest;
import com.example.elhorafi.dtos.UserDto;

import com.example.elhorafi.mappers.UserMapper;
import com.example.elhorafi.repositories.UserRepository;
import com.example.elhorafi.security.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;



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
    public JwtAuthenticationResponse signIn(SignInRequest request, HttpServletResponse response) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        var user = userRepository.findByEmailIgnoreCase(request.getEmail());

        var jwt = jwtUtil.generateAccessToken(user.getFirstName(), user.getRole());
        var refreshToken = jwtUtil.generateRefreshToken(user.getFirstName(), user.getRole());

        return JwtAuthenticationResponse.builder()
                .accessToken(jwt)
                .refreshToken(refreshToken)
                .build();
    }



//    @Override
//    public JwtAuthenticationResponse signUp(SignUpRequest request) {
//        Optional<Users> userFound = userRepository.findByEmailIgnoreCase(request.getEmail());
//
//        var user = Users.builder()
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .email(request.getEmail())
//                //.password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.ROLE_AGENT)
//                .build();
//
//        userRepository.save(user);
//
//        // GENERATE THE TOKEN
////        var jwt = jwtTokenProvider.generateAccessToken(request.getFirstName(), user.getRole());
////        var refreshToken = jwtTokenProvider.generateRefreshToken(request.getFirstName(), user.getRole());
//
//        return JwtAuthenticationResponse.builder()
//                .accessToken(jwt)
//                .refreshToken(refreshToken)
//                .build();
//    }

}
