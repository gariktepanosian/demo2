package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Trainee {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private LocalDate dateOfBirth;

    @Column
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return Objects.equals(id, trainee.id) && Objects.equals(dateOfBirth, trainee.dateOfBirth) && Objects.equals(userId, trainee.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfBirth, userId);
    }
}

