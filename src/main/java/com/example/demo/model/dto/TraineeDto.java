package com.example.demo.model.dto;

import com.example.demo.model.entity.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Objects;


public class TraineeDto {

    private Long id;

    private LocalDate dateOfBirth;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraineeDto that = (TraineeDto) o;
        return Objects.equals(id, that.id) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfBirth, user);
    }
}

