package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Long spetializationId;

    @Column
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpetializationId() {
        return spetializationId;
    }

    public void setSpetializationId(Long spetializationId) {
        this.spetializationId = spetializationId;
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
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id) && Objects.equals(spetializationId, trainer.spetializationId) && Objects.equals(userId, trainer.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spetializationId, userId);
    }
}
