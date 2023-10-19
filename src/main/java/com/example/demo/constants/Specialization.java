package com.example.demo.constants;

public enum Spetialization {

    TRAINER("Trainer");
    private final String spetialization;

    Spetialization(String spetialization) {
        this.spetialization = spetialization;
    }

    public String getSpetialization() {
        return spetialization;
    }
}
