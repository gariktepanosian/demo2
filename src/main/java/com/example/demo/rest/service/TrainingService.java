package com.example.demo.rest.service;

import com.example.demo.model.dto.TrainingDto;

import java.util.List;

public interface TrainingService {

    List<TrainingDto> findAll();

    TrainingDto create(TrainingDto training);

    TrainingDto update(TrainingDto training);

    String delete(Long trainingId);

    TrainingDto findById(Long trainingId);
}

