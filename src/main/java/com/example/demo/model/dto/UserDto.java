package com.example.demo.model.dto;

import com.example.demo.model.entity.Trainee;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

import java.util.List;
import java.util.Objects;


public class UserDto {


    private Long id;

    private String name;

    private String lastName;

    private String username;

    private String password;

    private Boolean isActive;
    @OneToOne(fetch = FetchType.LAZY)
    private List<Trainee> trainees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(name, userDto.name) && Objects.equals(lastName, userDto.lastName) && Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(isActive, userDto.isActive) && Objects.equals(trainees, userDto.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, username, password, isActive, trainees);
    }
}
