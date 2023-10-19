package com.example.demo.model.dto;

import com.example.demo.model.entity.Trainee;
import com.example.demo.model.entity.Trainer;
import com.example.demo.model.entity.TrainingType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Objects;


public class TrainingDto {

    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Trainee trainee;

    @OneToOne(fetch = FetchType.LAZY)
    private Trainer trainer;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private TrainingType trainingType;

    private LocalDate date;

    private Long duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingDto that = (TrainingDto) o;
        return Objects.equals(id, that.id) && Objects.equals(trainee, that.trainee) && Objects.equals(trainer, that.trainer) && Objects.equals(name, that.name) && Objects.equals(trainingType, that.trainingType) && Objects.equals(date, that.date) && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainee, trainer, name, trainingType, date, duration);
    }
}
