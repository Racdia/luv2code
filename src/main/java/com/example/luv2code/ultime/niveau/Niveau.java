package com.example.luv2code.ultime.niveau;


import com.example.luv2code.ultime.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String niveauName;
    @OneToMany
    @JsonIgnoreProperties("niveau")
    private List<Student> studentList=new ArrayList<>();

    

    public Niveau() {
    }

    public Niveau(String niveauName) {
        this.niveauName = niveauName;
    }

    public Niveau(Integer id, String niveauName, List<Student> studentList) {
        this.id = id;
        this.niveauName = niveauName;
        this.studentList = studentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNiveauName() {
        return niveauName;
    }

    public void setNiveauName(String niveauName) {
        this.niveauName = niveauName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
