package com.example.luv2code.ultime.dto;

public class InstructorDto {
    private String instructorUsername;
    private String email;
    private String quartier;

    public String getInstructorUsername() {
        return instructorUsername;
    }

    public void setInstructorUsername(String instructorUsername) {
        this.instructorUsername = instructorUsername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    @Override
    public String toString() {
        return "InstructorDto{" +
                "username='" + instructorUsername + '\'' +
                ", email='" + email + '\'' +
                ", quartier='" + quartier + '\'' +
                '}';
    }
}
