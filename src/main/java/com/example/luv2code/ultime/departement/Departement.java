package com.example.luv2code.ultime.departement;


import com.example.luv2code.ultime.niveau.Niveau;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String departementName;


    @OneToMany
    private List<Niveau> niveauList=new ArrayList<>();


    public Departement() {
    }

    public Departement(Integer id, String departementName, List<Niveau> niveauList) {
        this.id = id;
        this.departementName = departementName;
        this.niveauList = niveauList;
    }

    public Departement(String departementName) {
        this.departementName = departementName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartementName() {
        return departementName;
    }

    public void setDepartementName(String departementName) {
        this.departementName = departementName;
    }

    public List<Niveau> getNiveauList() {
        return niveauList;
    }

    public void setNiveauList(List<Niveau> niveauList) {
        this.niveauList = niveauList;
    }
}
