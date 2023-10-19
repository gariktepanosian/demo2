package com.example.demo.model.mapper;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toUser(UserDto userDtoDto) {
        User user = new User();
        user.setId(userDtoDto.getId());
        user.setName(userDtoDto.getName());
        user.setLastName(userDtoDto.getLastName());
        user.setUsername(userDtoDto.getUsername());
        user.setPassword(userDtoDto.getPassword());
        user.setActive(userDtoDto.getActive());
        user.setTrainees(userDtoDto.getTrainees());
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setActive(user.getActive());
        userDto.setTrainees(user.getTrainees());
        return userDto;
    }

    public static List<UserDto> toUserDtoList(List<User> userListEntities) {
        return userListEntities
                .stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors
                        .toList());
    }
}
