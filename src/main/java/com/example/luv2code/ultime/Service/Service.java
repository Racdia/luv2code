package com.example.luv2code.ultime.Service;




import com.example.luv2code.ultime.Exception.NotFoundException;
import com.example.luv2code.ultime.departement.Departement;
import com.example.luv2code.ultime.dto.InstructorDto;
import com.example.luv2code.ultime.course.Course;
import com.example.luv2code.ultime.dto.StudentDto;
import com.example.luv2code.ultime.istructor.Instructor;
import com.example.luv2code.ultime.niveau.Niveau;
import com.example.luv2code.ultime.student.Student;

import java.util.List;
import java.util.Optional;

public interface Service {

    Instructor addInstructor(Instructor instructor) ;
   Course addCourse(Course course);
   List<Instructor> getAllIns();

   List<Course> geAllCours();

   void addInsToCours(String instructorUsername,String coursName) ;

   Student addStudent(Student student);

   List<Student> getAllStudent() ;

   void addStudentToCourse(String StudentEmail,String coursName);

   void updateInstructor(Integer id, InstructorDto instructorDto) ;

   void updateStudent(Integer id, StudentDto studentDto);

  // void updateStudent(Integer id, StudentDto studentDto);

   void delleteCours(Integer id) throws NotFoundException;

   Optional<Instructor> getInstById(Integer id);

   Niveau addNiveau(Niveau niveau);

   List<Niveau> getAllNiveau();

   Departement addDepartement(Departement departement);

   void  addStudentToNiveau(String StudentEmail, String niveauName);

   List<Departement> getAllDpt();

   void addDptinlevel(String departementName,String niveauName);

}
