package com.example.demo.rest.repository;

import com.example.demo.constants.CSVReaderWriter;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static com.example.demo.constants.CSVReaderWriter.saveToCSV;

@Component
public class UserRepository {
    private final Map<Long, User> userMap = new ConcurrentHashMap<>();

    public static Long idCounter = 1L;

    private static final Logger logger = Logger.getLogger(TraineeRepository.class.getName());

    private final String csvFilePath = "user_data.csv";

    public UserRepository() {
        CSVReaderWriter.loadFromCSVUser(csvFilePath, userMap);
    }

    public User save(User user) {
        user.setId(idCounter++);
        userMap.put(user.getId(), user);
        saveToCSV(userMap, csvFilePath);

        logger.info("Added User : " + user.getUsername());
        return user;
    }

    public User findById(Long id) {
        logger.info("found User with ID: " + id);
        return userMap.get(id);
    }

    public List<User> findAll() {
        logger.info("found all Users");
        return new ArrayList<>(userMap.values());
    }

    public User update(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
            saveToCSV(userMap, csvFilePath);

            logger.info("Updated User with ID: " + user.getUsername());
            return user;
        }
        logger.info("User is not found" + user.getId());
        throw new UserNotFoundException("User is not found");
    }

    public void delete(Long id) {
        userMap.remove(id);
        saveToCSV(userMap, csvFilePath);

        logger.info("Deleted User with ID: " + id);
    }
}

