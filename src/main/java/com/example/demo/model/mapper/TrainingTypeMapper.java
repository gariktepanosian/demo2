package com.example.demo.model.mapper;

import com.example.demo.model.dto.TrainingTypeDto;
import com.example.demo.model.entity.TrainingType;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingTypeMapper {

    public static TrainingType toTrainingType(TrainingTypeDto trainingTypeDto) {
        TrainingType trainingType = new TrainingType();
        trainingType.setId(trainingTypeDto.getId());
        trainingType.setTypeName(trainingTypeDto.getTypeName());
        return trainingType;
    }

    public static TrainingTypeDto toTrainingTypeDto(TrainingType trainingType) {
        TrainingTypeDto trainingTypeDto = new TrainingTypeDto();
        trainingTypeDto.setId(trainingType.getId());
        trainingTypeDto.setTypeName(trainingType.getTypeName());
        return trainingTypeDto;
    }

    public static List<TrainingTypeDto> toTrainingTypeDtoList(List<TrainingType> trainingTypeListEntities) {
        return trainingTypeListEntities
                .stream()
                .map(TrainingTypeMapper::toTrainingTypeDto)
                .collect(Collectors
                        .toList());
    }
}
