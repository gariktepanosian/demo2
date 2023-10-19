package com.example.demo;

import com.example.demo.model.dto.TrainingDto;
import com.example.demo.model.entity.*;
import com.example.demo.rest.repository.TrainingRepository;
import com.example.demo.rest.service.TrainingService;
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
public class TrainingDaoTest {

    private final User user = new User();
    @InjectMocks
    private TrainingService trainingService;
    @Mock
    private TrainingRepository trainingRepository;

    @Test
    public void testFindAllTrainings() {
        List<Training> trainingList = new ArrayList<>();
        trainingList.add(new Training(1L, new Trainee(), new Trainer(), "Java Training", new TrainingType(), LocalDate.now(), 30L));
        trainingList.add(new Training());

        when(trainingRepository.findAll()).thenReturn(trainingList);

        List<TrainingDto> trainingDtoList = trainingService.findAll();
        assertEquals(2, trainingDtoList.size());
        assertEquals("Java Training", trainingDtoList.get(0).getName());
        assertEquals(30, trainingDtoList.get(0).getDuration());
    }

    @Test
    public void testCreateTraining() {
        TrainingDto trainingDto = new TrainingDto();
        when(trainingRepository.save(any(Training.class))).thenAnswer(invocation -> {
            Training training = invocation.getArgument(0);
            training.setId(1L); // Mock the ID assignment
            return training;
        });

        TrainingDto createdTraining = trainingService.create(trainingDto);

        assertNotNull(createdTraining.getId());
    }

    @Test
    public void testUpdateTraining() {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setId(1L);
        when(trainingRepository.update(any(Training.class))).thenAnswer(invocation -> {
            Training training = invocation.getArgument(0);
            return training;
        });

        TrainingDto updatedTraining = trainingService.update(trainingDto);

        assertNotNull(updatedTraining.getId());
        assertEquals(1L, updatedTraining.getId().longValue());
    }

    @Test
    public void testDeleteTraining() {
        when(trainingService.delete(1L));
        String result = trainingService.delete(1L);
        assertEquals("info was deleted", result);
    }

    @Test
    public void testFindTrainingById() {
        Training training = new Training(1L, new Trainee(), new Trainer(), "Java Training", new TrainingType(), LocalDate.now(), 30L);
        training.setId(1L);
        when(trainingRepository.findById(1L)).thenReturn(training);

        TrainingDto foundTraining = trainingService.findById(1L);
        assertEquals("Java Training", foundTraining.getName());
        assertEquals(30, foundTraining.getDuration());
    }
}
