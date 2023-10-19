package com.example.demo.rest.service.serviceImpl;

import com.example.demo.model.dto.TraineeDto;
import com.example.demo.model.entity.Trainee;
import com.example.demo.model.mapper.TraineeMapper;
import com.example.demo.rest.repository.TraineeRepository;
import com.example.demo.rest.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepository traineeRepository;

    @Autowired
    public TraineeServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    @Override
    public List<Trainee> findAll() {
        return traineeRepository.findAll();
    }

    @Override
    public TraineeDto create(TraineeDto trainee) {
        return TraineeMapper.toTraineeDto(traineeRepository.save(TraineeMapper.toTrainee(trainee)));
    }

    @Override
    @Transactional
    public TraineeDto update(TraineeDto trainee) {
        return TraineeMapper.toTraineeDto(traineeRepository.update(TraineeMapper.toTrainee(trainee)));
    }

    @Override
    public String delete(Long traineeId) {
        traineeRepository.delete(traineeId);
        return "info was deleted";
    }

    @Override
    public TraineeDto findById(Long traineeId) {
        return TraineeMapper.toTraineeDto(traineeRepository.findById(traineeId));
    }
}
