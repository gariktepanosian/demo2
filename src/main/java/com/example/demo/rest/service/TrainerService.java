package com.example.demo.rest.service;

import com.example.demo.model.dto.TrainerDto;

import java.util.List;

public interface TrainerService {

    List<TrainerDto> findAll();

    TrainerDto create(TrainerDto trainer);

    TrainerDto update(TrainerDto trainer);

    String delete(Long trainerId);

    TrainerDto findById(Long trainerId);
}

