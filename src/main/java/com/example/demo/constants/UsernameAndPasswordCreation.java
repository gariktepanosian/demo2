package com.example.demo.constants;

import com.example.demo.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsernameAndPasswordCreation {

    private static UserRepository userRepository;

    @Autowired
    public UsernameAndPasswordCreation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static String calculateUsername(String firstName, String lastName, Long id) {
        List<String> modifiedUsernames = new ArrayList<>();
        String baseUsername = firstName + "." + lastName;
        userRepository.findAll().stream().filter(user -> user.getUsername().equalsIgnoreCase(baseUsername))
                .map(user -> modifiedUsernames.add(baseUsername + id));
        if (modifiedUsernames.size() > 0) {
            return modifiedUsernames.get(0);
        }
        return baseUsername;
    }


    public static String generatePassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder passwordBuilder = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            passwordBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }

        return passwordBuilder.toString();
    }
}
