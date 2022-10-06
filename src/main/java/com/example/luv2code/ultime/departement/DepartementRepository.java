package com.example.luv2code.ultime.departement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    Departement findBydepartementName(String departementName);
}
