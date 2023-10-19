package com.example.demo;

import com.example.demo.model.dto.TraineeDto;
import com.example.demo.model.entity.Trainee;
import com.example.demo.model.entity.User;
import com.example.demo.rest.repository.TraineeRepository;
import com.example.demo.rest.service.TraineeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TraineeDaoTest {

    private final User user = new User();
    @InjectMocks
    private TraineeService traineeService;
    @Mock
    private TraineeRepository traineeRepository;

    @Test
    public void testFindAllTrainees() {
        List<Trainee> traineeList = new ArrayList<>();
        traineeList.add(new Trainee(1L, LocalDate.now(), user));
        traineeList.add(new Trainee());

        when(traineeRepository.findAll()).thenReturn(traineeList);

        List<TraineeDto> traineeDtoList = traineeService.findAll();
        assertEquals(2, traineeDtoList.size());
        assertEquals(LocalDate.now(), traineeDtoList.get(0).getDateOfBirth());
        assertEquals(user, traineeDtoList.get(0).getUser());
    }

    @Test
    public void testCreateTrainee() {
        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setUser(new User());
        when(traineeRepository.save(any(Trainee.class))).thenAnswer(invocation -> {
            Trainee trainee = invocation.getArgument(0);
            trainee.setId(1L); // Mock the ID assignment
            return trainee;
        });

        TraineeDto createdTrainee = traineeService.create(traineeDto);

        assertNotNull(createdTrainee.getId());
        assertNotNull(createdTrainee.getUser().getUsername());
        assertEquals(10, createdTrainee.getUser().getPassword().length());
    }

    @Test
    public void testUpdateTrainee() {
        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setId(1L);
        when(traineeRepository.update(any(Trainee.class))).thenAnswer(invocation -> {
            Trainee trainee = invocation.getArgument(0);
            return trainee;
        });

        TraineeDto updatedTrainee = traineeService.update(traineeDto);

        assertNotNull(updatedTrainee.getId());
        assertEquals(1L, updatedTrainee.getId().longValue());
    }

    @Test
    public void testDeleteTrainee() {
        when(traineeService.delete(1L));
        String result = traineeService.delete(1L);
        assertEquals("info was deleted", result);
    }

    @Test
    public void testFindTraineeById() {
        Trainee trainee = new Trainee(1L, LocalDate.now(), user);
        trainee.setId(1L);
        when(traineeRepository.findById(1L)).thenReturn(trainee);

        TraineeDto foundTrainee = traineeService.findById(1L);
        assertEquals("John", foundTrainee.getDateOfBirth());
        assertEquals(1L, foundTrainee.getId().longValue());
    }
}

