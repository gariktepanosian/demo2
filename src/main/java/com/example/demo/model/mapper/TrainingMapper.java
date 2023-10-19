package com.example.demo.model.mapper;

import com.example.demo.model.dto.TrainingDto;
import com.example.demo.model.entity.Training;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingMapper {

    public static Training toTraining(TrainingDto trainingDto) {
        Training training = new Training();
        training.setId(trainingDto.getId());
        training.setTrainee(trainingDto.getTrainee());
        training.setTrainer(trainingDto.getTrainer());
        training.setTrainingType(trainingDto.getTrainingType());
        training.setDate(trainingDto.getDate());
        training.setName(trainingDto.getName());
        training.setDuration(trainingDto.getDuration());
        return training;
    }

    public static TrainingDto toTrainingDto(Training training) {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setId(training.getId());
        trainingDto.setTrainee(training.getTrainee());
        trainingDto.setTrainer(training.getTrainer());
        trainingDto.setTrainingType(training.getTrainingType());
        trainingDto.setDuration(training.getDuration());
        trainingDto.setDate(training.getDate());
        trainingDto.setName(training.getName());
        return trainingDto;
    }

    public static List<TrainingDto> toTrainingDtoList(List<Training> trainingListEntities) {
        return trainingListEntities
                .stream()
                .map(TrainingMapper::toTrainingDto)
                .collect(Collectors
                        .toList());
    }
}
