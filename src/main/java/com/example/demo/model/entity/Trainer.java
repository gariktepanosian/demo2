package com.example.demo.model.entity;

import com.example.demo.constants.Specialization;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Trainer(Long id, Specialization specialization, User user) {
        this.id = id;
        this.specialization = specialization;
        this.user = user;
    }

    public Trainer() {
    }

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
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id) && specialization == trainer.specialization && Objects.equals(user, trainer.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialization, user);
    }
}
