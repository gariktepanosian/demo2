package com.example.demo;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.rest.repository.UserRepository;
import com.example.demo.rest.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDaoTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L,"john", "joe","john.doe", "generatedpass" ,true));
        userList.add(new User(1L,"jane", "bird","john.doe", "generatedpass" ,false));

        when(userRepository.findAll()).thenReturn(userList);

        List<UserDto> userDtoList = userService.findAll();
        assertEquals(2, userDtoList.size());
        assertEquals("john.doe", userDtoList.get(0).getUsername());
        assertEquals("jane.smith", userDtoList.get(1).getUsername());
    }

    @Test
    public void testCreateUser() {
        UserDto userDto = new UserDto();
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            return user;
        });

        UserDto createdUser = userService.create(userDto);

        assertNotNull(createdUser);
    }

    @Test
    public void testUpdateUser() {
        UserDto userDto = new UserDto();
        when(userRepository.update(any(User.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            return user;
        });

        UserDto updatedUser = userService.update(userDto);

        assertNotNull(updatedUser);
    }

    @Test
    public void testDeleteUser() {
        when(userService.delete(1L));
        String result = userService.delete(1L);
        assertEquals("info was deleted", result);
    }

    @Test
    public void testFindUserById() {
        User user = new User(1L,"john", "joe","john.doe", "generatedpass" ,true);
        when(userRepository.findById(1L)).thenReturn(user);

        UserDto foundUser = userService.findById(1L);
        assertEquals("john.doe", foundUser.getUsername());
    }
}

