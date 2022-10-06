package com.example.luv2code.ultime.student;


import com.example.luv2code.ultime.course.Course;
import com.example.luv2code.ultime.niveau.Niveau;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@JsonPropertyOrder({"id","studentFirstName" ,"studentLastName","StudentEmail","Adresse","courseList","niveau"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String studentFirstName;
    private String studentLastName;
    private  String StudentEmail;
    private String Adresse;
    @ManyToMany
    @JsonIgnoreProperties("studentList")
    private Set<Course> courseList;

    @OneToOne
    @JsonIgnoreProperties("studentList")
    private Niveau niveau;

    public Student() {
    }

    public Student(Integer id, String studentFirstName, String studentLastName, String studentEmail, String adresse, Set<Course> courseList, Niveau niveau) {
        this.id = id;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        StudentEmail = studentEmail;
        Adresse = adresse;
        this.courseList = courseList;
        this.niveau = niveau;
    }

    public Student(String studentFirstName, String studentLastName, String studentEmail, String adresse) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        StudentEmail = studentEmail;
        Adresse = adresse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public Set<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = courseList;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
