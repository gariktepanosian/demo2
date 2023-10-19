package com.example.demo.service;

import com.example.demo.model.entity.Trainee;

public interface TraineeService {
    Trainee createTrainee(Trainee trainee);

    Trainee updateTrainee(Trainee trainee);

    String deleteTrainee(Long traineeId);

    Trainee getTraineeById(Long traineeId);
}

