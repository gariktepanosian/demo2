package com.example.demo.rest.service;

import com.example.demo.model.dto.TrainingTypeDto;

import java.util.List;

public interface TrainingTypeService {

    List<TrainingTypeDto> findAll();

    TrainingTypeDto create(TrainingTypeDto trainingType);

    TrainingTypeDto update(TrainingTypeDto trainingType);

    String delete(Long trainingTypeId);

    TrainingTypeDto findById(Long trainingTypeId);
}

