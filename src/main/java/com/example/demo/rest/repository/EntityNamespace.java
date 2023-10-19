package com.example.demo.rest.repository;

import com.example.demo.model.entity.Trainee;
import com.example.demo.model.entity.Trainer;
import com.example.demo.model.entity.Training;

public class EntityNamespace {

    private static final String TRAINER_NAMESPACE = "trainer";
    private static final String TRAINEE_NAMESPACE = "trainee";
    private static final String TRAINING_NAMESPACE = "training";

    public static String getNamespace(Class<?> entityClass) {
        if (entityClass.equals(Trainer.class)) {
            return TRAINER_NAMESPACE;
        } else if (entityClass.equals(Trainee.class)) {
            return TRAINEE_NAMESPACE;
        } else if (entityClass.equals(Training.class)) {
            return TRAINING_NAMESPACE;
        } else {
            throw new IllegalArgumentException("Unsupported entity class: " + entityClass);
        }
    }
}
