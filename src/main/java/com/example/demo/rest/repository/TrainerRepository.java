package com.example.demo.rest.repository;

import com.example.demo.constants.CSVReaderWriter;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.entity.Trainer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static com.example.demo.constants.CSVReaderWriter.saveToCSV;

@Component
public class TrainerRepository {
    private final Map<Long, Trainer> trainerMap = new ConcurrentHashMap<>();
    public static Long idCounter = 1L;
    private static final Logger logger = Logger.getLogger(TrainerRepository.class.getName());
    private final String csvFilePath = "trainer_data.csv";

    public TrainerRepository() {
        CSVReaderWriter.loadFromCSVTrainer(csvFilePath, trainerMap);
    }

    public Trainer save(Trainer trainer) {
        trainer.setId(idCounter++);
        trainerMap.put(trainer.getId(), trainer);
        saveToCSV(trainerMap, csvFilePath);

        logger.info("Added Trainer: " + trainer.getUser().getUsername());
        return trainer;
    }

    public Trainer findById(Long id) {
        logger.info("found Trainer with ID: " + id);
        return trainerMap.get(id);
    }

    public List<Trainer> findAll() {
        logger.info("found all Trainer");
        return new ArrayList<>(trainerMap.values());
    }

    public Trainer update(Trainer trainer) {
        if (trainerMap.containsKey(trainer.getId())) {
            trainerMap.put(trainer.getId(), trainer);
            saveToCSV(trainerMap, csvFilePath);

            logger.info("Updated Trainer : " + trainer.getUser().getUsername());
            return trainer;
        }

        logger.info("Trainer is not found : " + trainer.getId());
        throw new UserNotFoundException("Trainer is not found");
    }

    public void delete(Long id) {
        saveToCSV(trainerMap, csvFilePath);
        trainerMap.remove(id);

        logger.info("Deleted Trainer with ID: " + id);
    }
}

