package com.example.demo.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "trainee")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Trainee(Long id, LocalDate dateOfBirth, User user) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.user = user;
    }

    public Trainee() {
    }

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
        Trainee trainee = (Trainee) o;
        return Objects.equals(id, trainee.id) && Objects.equals(dateOfBirth, trainee.dateOfBirth) && Objects.equals(user, trainee.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfBirth, user);
    }
}

