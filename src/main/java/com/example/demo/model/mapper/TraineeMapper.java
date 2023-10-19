package com.example.demo.model.mapper;

import com.example.demo.model.dto.TraineeDto;
import com.example.demo.model.entity.Trainee;

import java.util.List;
import java.util.stream.Collectors;

public class TraineeMapper {

    public static Trainee toTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
        trainee.setId(traineeDto.getId());
        trainee.setDateOfBirth(traineeDto.getDateOfBirth());
        trainee.setUser(traineeDto.getUser());
        return trainee;
    }

    public static TraineeDto toTraineeDto(Trainee trainee) {
        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setId(trainee.getId());
        traineeDto.setDateOfBirth(trainee.getDateOfBirth());
        traineeDto.setUser(trainee.getUser());
        return traineeDto;
    }

    public static List<TraineeDto> toSTraineeDtoList(List<Trainee> traineeListEntities) {
        return traineeListEntities
                .stream()
                .map(TraineeMapper::toTraineeDto)
                .collect(Collectors
                        .toList());
    }
}
