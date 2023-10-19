package com.example.demo.rest.repository;

import com.example.demo.constants.CSVReaderWriter;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.entity.TrainingType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static com.example.demo.constants.CSVReaderWriter.saveToCSV;

@Component
public class TrainingTypeRepository {
    private final Map<Long, TrainingType> trainingTypeMap = new ConcurrentHashMap<>();
    public static Long idCounter = 1L;
    private static final Logger logger = Logger.getLogger(TrainingTypeRepository.class.getName());
    private final String csvFilePath = "trainingType_data.csv";

    public TrainingTypeRepository() {
        CSVReaderWriter.loadFromCSVTrainingType(csvFilePath,trainingTypeMap);
    }

    public TrainingType save(TrainingType trainingType) {
        trainingType.setId(idCounter++);
        trainingTypeMap.put(trainingType.getId(), trainingType);
        saveToCSV(trainingTypeMap,csvFilePath);
        logger.info("Added TrainingType with ID: " + trainingType.getTypeName());
        return trainingType;
    }

    public TrainingType findById(Long id) {
        logger.info("found TrainingType with ID: " + id);
        return trainingTypeMap.get(id);
    }

    public List<TrainingType> findAll() {
        logger.info("found all TrainingType");
        return new ArrayList<>(trainingTypeMap.values());
    }

    public TrainingType update(TrainingType trainingType) {
        if (trainingTypeMap.containsKey(trainingType.getId())) {
            trainingTypeMap.put(trainingType.getId(), trainingType);
            saveToCSV(trainingTypeMap,csvFilePath);

            logger.info("Updated Trainee " + trainingType.getTypeName());
            return trainingType;
        }
        logger.info("TrainingType is not found" + trainingType.getId());
        throw new UserNotFoundException("TrainingType is not found");
    }

    public void delete(Long id) {
        trainingTypeMap.remove(id);
        saveToCSV(trainingTypeMap,csvFilePath);
        logger.info("Deleted TrainingType with ID: " + id);
    }
}

