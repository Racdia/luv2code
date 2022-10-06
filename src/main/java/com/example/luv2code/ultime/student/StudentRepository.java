package com.example.luv2code.ultime.student;


import com.example.luv2code.ultime.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("select s from Student s where s.StudentEmail=?1")
   Optional<Student> findBystudentEmail(String StudentEmail);


}
