package com.example.demo.service.serviceImpl;

import com.example.demo.model.entity.Trainee;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;

public class TraineeServiceImpl implements TraineeService {

    TraineeRepository traineeRepository;

    @Autowired
    public TraineeServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    @Override
    public Trainee createTrainee(Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    @Override
    public Trainee updateTrainee(Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    @Override
    public String deleteTrainee(Long traineeId) {
    traineeRepository.delete(getTraineeById(traineeId));
    return "info was deleted";
    }

    @Override
    public Trainee getTraineeById(Long traineeId) {
        return traineeRepository.findById(traineeId).orElseThrow();
    }
}
