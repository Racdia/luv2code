package com.example.luv2code.ultime.niveau;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NiveauRepository  extends JpaRepository<Niveau,Integer> {

      @Override
      Optional<Niveau> findById(Integer integer);

      Optional<Niveau> findByniveauName(String niveauName);

}
