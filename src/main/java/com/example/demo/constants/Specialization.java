package com.example.demo.constants;

public enum Specialization {

    TRAINER("Trainer");
    private final String specialization;

    Specialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
