package com.example.demo.rest.repository;

import com.example.demo.constants.CSVReaderWriter;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.entity.Trainee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static com.example.demo.constants.CSVReaderWriter.saveToCSV;

@Component
public class TraineeRepository {
    private final Map<Long, Trainee> traineeMap = new ConcurrentHashMap<>();
    public static Long idCounter = 1L;
    private static final Logger logger = Logger.getLogger(TraineeRepository.class.getName());
    private final String csvFilePath = "trainee_data.csv";

    public TraineeRepository() {
        CSVReaderWriter.loadFromCSV(csvFilePath, traineeMap);
    }

    public Trainee save(Trainee trainee) {
        trainee.setId(idCounter++);
        traineeMap.put(trainee.getId(), trainee);
        saveToCSV(traineeMap, csvFilePath);

        logger.info("Added Trainee : " + trainee.getUser().getUsername());
        return trainee;
    }

    public Trainee findById(Long id) {
        logger.info("found Trainee with ID: " + id);
        return traineeMap.get(id);
    }

    public List<Trainee> findAll() {
        logger.info("found all Trainee");
        return new ArrayList<>(traineeMap.values());
    }

    public Trainee update(Trainee trainee) {
        if (traineeMap.containsKey(trainee.getId())) {
            traineeMap.put(trainee.getId(), trainee);
            saveToCSV(traineeMap, csvFilePath);

            logger.info("Updated Trainee : " + trainee.getUser().getUsername());
            return trainee;
        }

        logger.info("Trainee is not found " + trainee.getId());
        throw new UserNotFoundException("Trainee is not found");
    }

    public void delete(Long id) {
        traineeMap.remove(id);
        saveToCSV(traineeMap, csvFilePath);

        logger.info("Deleted Trainee with ID: " + id);
    }
}

