package com.example.luv2code.ultime.course;


import com.example.luv2code.ultime.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Course, Integer> {
   // @Query("SELECT  s from Course s where s.coursName=?1")
    Course findBycoursName(String coursName);
}
