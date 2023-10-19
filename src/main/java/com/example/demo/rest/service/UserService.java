package com.example.demo.rest.service;

import com.example.demo.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto create(UserDto user);

    UserDto update(UserDto user);

    String delete(Long userId);

    UserDto findById(Long userId);
}

