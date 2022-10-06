package com.example.luv2code.ultime.istructor;

import com.example.luv2code.ultime.istructor.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

    @Query("select s from Instructor s where s.instructorUsername=?1")
    Optional<Instructor> findInsByName(String instructorUsername);

    @Query("select c from Instructor c where c.email like :x")
    Optional<Instructor> findInsByEmail(@Param("x") String email);


   // Optional<Instructor> findInsById(Integer id);
}
