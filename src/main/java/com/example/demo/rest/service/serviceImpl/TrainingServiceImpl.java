package com.example.demo.rest.service.serviceImpl;

import com.example.demo.model.dto.TrainingDto;
import com.example.demo.model.mapper.TrainingMapper;
import com.example.demo.rest.repository.TrainingRepository;
import com.example.demo.rest.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrainingServiceImpl implements TrainingService {

    public final TrainingRepository trainingRepository;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<TrainingDto> findAll() {
        return TrainingMapper.toTrainingDtoList(trainingRepository.findAll());
    }

    @Override
    public TrainingDto create(TrainingDto training) {
        return TrainingMapper.toTrainingDto(trainingRepository.save(TrainingMapper.toTraining(training)));
    }

    @Override
    public TrainingDto update(TrainingDto training) {
        return TrainingMapper.toTrainingDto(trainingRepository.update(TrainingMapper.toTraining(training)));
    }

    @Override
    public String delete(Long trainingId) {
        trainingRepository.delete(trainingId);
        return "info was deleted";
    }

    @Override
    public TrainingDto findById(Long trainingId) {
        return TrainingMapper.toTrainingDto(trainingRepository.findById(trainingId));
    }
}
