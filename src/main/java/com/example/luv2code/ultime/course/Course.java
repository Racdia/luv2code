package com.example.luv2code.ultime.course;


import com.example.luv2code.ultime.student.Student;
import com.example.luv2code.ultime.istructor.Instructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String coursName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JsonIgnoreProperties("courses")
    private Instructor instructor;


    @ManyToMany
    @JsonIgnoreProperties("courseList")
    private Set<Student> studentList;

    public Course() {
    }

    public Course(Integer id, String coursName) {
        this.id = id;
        this.coursName = coursName;
    }

    public Course(Integer id, String coursName, Instructor instructor, Set<Student> studentList) {
        this.id = id;
        this.coursName = coursName;
        this.instructor = instructor;
        this.studentList=studentList;
    }

    public Course(String coursName) {
        this.coursName=coursName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursName() {
        return coursName;
    }

    public void setCoursName(String coursName) {
        this.coursName = coursName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }
}
