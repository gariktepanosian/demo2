package com.example.demo;

import com.example.demo.model.dto.TrainingTypeDto;
import com.example.demo.model.entity.TrainingType;
import com.example.demo.rest.repository.TrainingTypeRepository;
import com.example.demo.rest.service.TrainingTypeService;
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
public class TrainingTypeDaoTest {

    @InjectMocks
    private TrainingTypeService trainingTypeService;
    @Mock
    private TrainingTypeRepository trainingTypeRepository;

    @Test
    public void testFindAllTrainingTypes() {
        List<TrainingType> trainingTypeList = new ArrayList<>();
        trainingTypeList.add(new TrainingType(1L, "Java Training"));
        trainingTypeList.add(new TrainingType(1L, "Python Training"));

        when(trainingTypeRepository.findAll()).thenReturn(trainingTypeList);

        List<TrainingTypeDto> trainingTypeDtoList = trainingTypeService.findAll();
        assertEquals(2, trainingTypeDtoList.size());
        assertEquals("Java Training", trainingTypeDtoList.get(0).getTypeName());
        assertEquals("Python Training", trainingTypeDtoList.get(1).getTypeName());
    }

    @Test
    public void testCreateTrainingType() {
        TrainingTypeDto trainingTypeDto = new TrainingTypeDto();
        when(trainingTypeRepository.save(any(TrainingType.class))).thenAnswer(invocation -> {
            TrainingType trainingType = invocation.getArgument(0);
            return trainingType;
        });

        TrainingTypeDto createdTrainingType = trainingTypeService.create(trainingTypeDto);

        assertNotNull(createdTrainingType);
    }

    @Test
    public void testUpdateTrainingType() {
        TrainingTypeDto trainingTypeDto = new TrainingTypeDto();
        when(trainingTypeRepository.update(any(TrainingType.class))).thenAnswer(invocation -> {
            TrainingType trainingType = invocation.getArgument(0);
            return trainingType;
        });

        TrainingTypeDto updatedTrainingType = trainingTypeService.update(trainingTypeDto);

        assertNotNull(updatedTrainingType);
    }

    @Test
    public void testDeleteTrainingType() {
        when(trainingTypeService.delete(1L));
        String result = trainingTypeService.delete(1L);
        assertEquals("info was deleted", result);
    }

    @Test
    public void testFindTrainingTypeById() {
        TrainingType trainingType = new TrainingType(1L, "Java Training");
        when(trainingTypeRepository.findById(1L)).thenReturn(trainingType);

        TrainingTypeDto foundTrainingType = trainingTypeService.findById(1L);
        assertEquals("Java Training", foundTrainingType.getTypeName());
    }
}

