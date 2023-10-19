package com.example.demo.rest.service.serviceImpl;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.rest.repository.UserRepository;
import com.example.demo.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        return UserMapper.toUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDto create(UserDto user) {
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(user)));
    }

    @Override
    @Transactional
    public UserDto update(UserDto user) {
        return UserMapper.toUserDto(userRepository.update(UserMapper.toUser(user)));
    }

    @Override
    public String delete(Long userId) {
        userRepository.delete(userId);
        return "info was deleted";
    }

    @Override
    public UserDto findById(Long userId) {
        return UserMapper.toUserDto(userRepository.findById(userId));
    }
}
