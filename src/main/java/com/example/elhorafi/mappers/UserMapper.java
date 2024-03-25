package com.example.elhorafi.mappers;


import com.example.elhorafi.dtos.UserDto;
import com.example.elhorafi.entities.Users;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface UserMapper {
    Users mapToEntity(UserDto userDto);
    UserDto mapToDto(Users users);
    List<Users> mapToEntityList(List<UserDto> userDto);
    List<UserDto> mapToDtoList(List<Users> users);
}
