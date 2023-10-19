package com.example.demo.rest.service.serviceImpl;

import com.example.demo.model.dto.TrainingTypeDto;
import com.example.demo.model.mapper.TrainingTypeMapper;
import com.example.demo.rest.repository.TrainingTypeRepository;
import com.example.demo.rest.service.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrainingTypeServiceImpl implements TrainingTypeService {

    public final TrainingTypeRepository trainingTypeRepository;

    @Autowired
    public TrainingTypeServiceImpl(TrainingTypeRepository trainingTypeRepository) {
        this.trainingTypeRepository = trainingTypeRepository;
    }

    @Override
    public List<TrainingTypeDto> findAll() {
        return TrainingTypeMapper.toTrainingTypeDtoList(trainingTypeRepository.findAll());
    }

    @Override
    public TrainingTypeDto create(TrainingTypeDto trainingType) {
        return TrainingTypeMapper.toTrainingTypeDto(trainingTypeRepository.save(TrainingTypeMapper.toTrainingType(trainingType)));
    }

    @Override
    public TrainingTypeDto update(TrainingTypeDto trainingType) {
        return TrainingTypeMapper.toTrainingTypeDto(trainingTypeRepository.update(TrainingTypeMapper.toTrainingType(trainingType)));
    }

    @Override
    public String delete(Long trainingTypeId) {
        trainingTypeRepository.delete(trainingTypeId);
        return "info was deleted";
    }

    @Override
    public TrainingTypeDto findById(Long trainingTypeId) {
        return TrainingTypeMapper.toTrainingTypeDto(trainingTypeRepository.findById(trainingTypeId));
    }
}
