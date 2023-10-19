package com.example.demo.rest.repository;

import com.example.demo.model.entity.Trainee;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TraineeRepository {
    private Map<Long, Trainee> traineeMap = new ConcurrentHashMap<>();
    private Long idCounter = 1L;

    public Trainee save(Trainee trainee) {
        trainee.setId(idCounter++);
        traineeMap.put(trainee.getId(), trainee);
        return trainee;
    }

    public Trainee findById(Long id) {
        return traineeMap.get(id);
    }

    public List<Trainee> findAll() {
        return new ArrayList<>(traineeMap.values());
    }

    public Trainee update(Trainee trainee) {
        if (traineeMap.containsKey(trainee.getId())) {
            traineeMap.put(trainee.getId(), trainee);
            return trainee;
        }
        return null;
    }

    public void delete(Long id) {
        traineeMap.remove(id);
    }
    }

