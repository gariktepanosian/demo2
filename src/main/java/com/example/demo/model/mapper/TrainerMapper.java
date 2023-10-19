package com.example.demo.model.mapper;

import com.example.demo.model.dto.TrainerDto;
import com.example.demo.model.entity.Trainer;

import java.util.List;
import java.util.stream.Collectors;

public class TrainerMapper {

    public static Trainer toTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setId(trainerDto.getId());
        trainer.setSpecialization(trainerDto.getSpecialization());
        trainer.setUser(trainerDto.getUser());
        return trainer;
    }

    public static TrainerDto toTraineeDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setId(trainer.getId());
        trainerDto.setSpecialization(trainer.getSpecialization());
        trainerDto.setUser(trainer.getUser());
        return trainerDto;
    }


    public static List<TrainerDto> toSTraineeDtoList(List<Trainer> trainerListEntities) {
        return trainerListEntities
                .stream()
                .map(TrainerMapper::toTraineeDto)
                .collect(Collectors
                        .toList());
    }
}
