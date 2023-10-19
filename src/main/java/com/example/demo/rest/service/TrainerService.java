package com.example.demo.rest.service;

import com.example.demo.model.dto.TraineeDto;
import com.example.demo.model.entity.Trainee;

import java.util.List;

public interface TraineeService {

    List<Trainee> findAll();

    TraineeDto create(TraineeDto trainee);

    TraineeDto update(TraineeDto trainee);

    String delete(Long traineeId);

    TraineeDto findById(Long traineeId);
}

