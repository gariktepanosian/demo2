package com.example.demo;

import com.example.demo.constants.Specialization;
import com.example.demo.model.dto.TrainerDto;
import com.example.demo.model.entity.Trainer;
import com.example.demo.model.entity.User;
import com.example.demo.rest.repository.TrainerRepository;
import com.example.demo.rest.service.TrainerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TrainerDaoTest {

    private final User user = new User();
    @InjectMocks
    private TrainerService trainerService;
    @Mock
    private TrainerRepository trainerRepository;

    @Test
    public void testFindAllTrainers() {
        List<Trainer> trainerList = new ArrayList<>();
        trainerList.add(new Trainer(1L, Specialization.TRAINER, user));
        trainerList.add(new Trainer());

        when(trainerRepository.findAll()).thenReturn(trainerList);

        List<TrainerDto> trainerDtoList = trainerService.findAll();
        assertEquals(2, trainerDtoList.size());
        assertEquals(Specialization.TRAINER, trainerDtoList.get(0).getSpecialization());
        assertEquals(user, trainerDtoList.get(0).getUser());
    }

    @Test
    public void testCreateTrainer() {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setUser(new User());
        when(trainerRepository.save(any(Trainer.class))).thenAnswer(invocation -> {
            Trainer trainer = invocation.getArgument(0);
            trainer.setId(1L); // Mock the ID assignment
            return trainer;
        });

        TrainerDto createdTrainer = trainerService.create(trainerDto);

        assertNotNull(createdTrainer.getId());
        assertNotNull(createdTrainer.getUser().getUsername());
        assertEquals(10, createdTrainer.getUser().getPassword().length());
    }

    @Test
    public void testUpdateTrainer() {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setId(1L);
        when(trainerRepository.update(any(Trainer.class))).thenAnswer(invocation -> {
            Trainer trainer = invocation.getArgument(0);
            return trainer;
        });

        TrainerDto updatedTrainer = trainerService.update(trainerDto);

        assertNotNull(updatedTrainer.getId());
        assertEquals(1L, updatedTrainer.getId().longValue());
    }

    @Test
    public void testDeleteTrainer() {
        when(trainerService.delete(1L));
        String result = trainerService.delete(1L);
        assertEquals("info was deleted", result);
    }

    @Test
    public void testFindTraineeById() {
        Trainer trainer = new Trainer(1L, Specialization.TRAINER, user);
        trainer.setId(1L);
        when(trainerRepository.findById(1L)).thenReturn(trainer);

        TrainerDto foundTrainer = trainerService.findById(1L);
        assertEquals("John", foundTrainer.getSpecialization());
        assertEquals(1L, foundTrainer.getId().longValue());
    }
}