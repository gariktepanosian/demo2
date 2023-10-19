package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private Long traineeId;

    @Column
    private Long trainerId;

    @Column
    private String name;

    @Column
    private Long typeId;

    @Column
   private LocalDate date;

    @Column
    private Long duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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
        Training training = (Training) o;
        return Objects.equals(id, training.id) && Objects.equals(traineeId, training.traineeId) && Objects.equals(trainerId, training.trainerId) && Objects.equals(name, training.name) && Objects.equals(typeId, training.typeId) && Objects.equals(date, training.date) && Objects.equals(duration, training.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, traineeId, trainerId, name, typeId, date, duration);
    }
}
