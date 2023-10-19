package com.example.demo.rest.service.serviceImpl;

import com.example.demo.model.dto.TrainerDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.mapper.TrainerMapper;
import com.example.demo.rest.repository.TrainerRepository;
import com.example.demo.rest.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.demo.constants.UsernameAndPasswordCreation.calculateUsername;
import static com.example.demo.constants.UsernameAndPasswordCreation.generatePassword;
import static com.example.demo.rest.repository.TraineeRepository.idCounter;

public class TrainerServiceImpl implements TrainerService {

    public final TrainerRepository trainerRepository;

    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public List<TrainerDto> findAll() {
        return TrainerMapper.toSTraineeDtoList(trainerRepository.findAll());
    }

    @Override
    public TrainerDto create(TrainerDto trainer) {
        User user = trainer.getUser();
        user.setUsername(calculateUsername(user.getName(),user.getLastName(),idCounter));
        user.setPassword(generatePassword(10));
        return TrainerMapper.toTraineeDto(trainerRepository.save(TrainerMapper.toTrainer(trainer)));
    }

    @Override
    public TrainerDto update(TrainerDto trainer) {
        return TrainerMapper.toTraineeDto(trainerRepository.update(TrainerMapper.toTrainer(trainer)));
    }

    @Override
    public String delete(Long trainerId) {
        trainerRepository.delete(trainerId);
        return "info was deleted";
    }

    @Override
    public TrainerDto findById(Long trainerId) {
        return TrainerMapper.toTraineeDto(trainerRepository.findById(trainerId));
    }
}
