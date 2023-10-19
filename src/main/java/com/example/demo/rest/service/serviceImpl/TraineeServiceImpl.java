package com.example.demo.rest.service.serviceImpl;

import com.example.demo.model.dto.TraineeDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.mapper.TraineeMapper;
import com.example.demo.rest.repository.TraineeRepository;
import com.example.demo.rest.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.constants.UsernameAndPasswordCreation.calculateUsername;
import static com.example.demo.constants.UsernameAndPasswordCreation.generatePassword;
import static com.example.demo.rest.repository.TraineeRepository.idCounter;

@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepository traineeRepository;

    @Autowired
    public TraineeServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    @Override
    public List<TraineeDto> findAll() {
        return TraineeMapper.toSTraineeDtoList(traineeRepository.findAll());
    }

    @Override
    public TraineeDto create(TraineeDto trainee) {
        User user = trainee.getUser();
        user.setUsername(calculateUsername(user.getName(),user.getLastName(),idCounter));
        user.setPassword(generatePassword(10));
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
