package com.example.demo.rest.repository;

import com.example.demo.constants.CSVReaderWriter;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.entity.Training;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static com.example.demo.constants.CSVReaderWriter.saveToCSV;

@Component
public class TrainingRepository {
    private final Map<Long, Training> trainingMap = new ConcurrentHashMap<>();

    public static Long idCounter = 1L;

    private static final Logger logger = Logger.getLogger(TrainingRepository.class.getName());

    private final String csvFilePath = "training_data.csv";

    public TrainingRepository() {
        CSVReaderWriter.loadFromCSVTraining(csvFilePath,trainingMap);
    }

    public Training save(Training training) {
        training.setId(idCounter++);
        trainingMap.put(training.getId(), training);
        saveToCSV(trainingMap,csvFilePath);

        logger.info("Added Training : " + training.getName());
        return training;
    }

    public Training findById(Long id) {
        logger.info("found Training with ID: " + id);
        return trainingMap.get(id);
    }

    public List<Training> findAll() {
        logger.info("found all Training");
        return new ArrayList<>(trainingMap.values());
    }

    public Training update(Training training) {
        if (trainingMap.containsKey(training.getId())) {
            trainingMap.put(training.getId(), training);
            saveToCSV(trainingMap,csvFilePath);

            logger.info("Updated Training : " + training.getName());
            return training;
        }

        logger.info("Training is not found " + training.getId());
        throw new UserNotFoundException("Training is not found");
    }

    public void delete(Long id) {
        trainingMap.remove(id);
        saveToCSV(trainingMap,csvFilePath);
        logger.info("Deleted Training with ID: " + id);
    }
}

