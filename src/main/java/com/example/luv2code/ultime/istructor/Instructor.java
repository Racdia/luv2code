package com.example.luv2code.ultime.istructor;


import com.example.luv2code.ultime.course.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String instructorUsername;
    private String email;
    private String quartier;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnoreProperties("instructor")
    private List<Course> courses=new ArrayList<>();

    public Instructor() {
    }

    public Instructor(Integer id, String instructorUsername, String email, String quartier) {
        this.id = id;
        this.instructorUsername = instructorUsername;
        this.email = email;
        this.quartier = quartier;
    }

    public Instructor(int id, String instructorUsername, String email, String quartier, List<Course> courses) {
        this.id = id;
        this.instructorUsername = instructorUsername;
        this.email = email;
        this.quartier = quartier;
        this.courses = courses;
    }

    public Instructor(String instructorUsername, String email, String quartier) {
        this.instructorUsername=instructorUsername;
        this.email=email;
        this.quartier=quartier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", username='" + instructorUsername + '\'' +
                ", email='" + email + '\'' +
                ", quartier='" + quartier + '\'' +
                '}';
    }
}
