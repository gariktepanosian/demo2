package com.example.demo.model.dto;

import com.example.demo.constants.Specialization;
import com.example.demo.model.entity.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

import java.util.Objects;


public class TrainerDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
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
        TrainerDto that = (TrainerDto) o;
        return Objects.equals(id, that.id) && specialization == that.specialization && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialization, user);
    }
}
