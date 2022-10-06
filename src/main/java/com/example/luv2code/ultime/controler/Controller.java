package com.example.luv2code.ultime.controler;


import com.example.luv2code.ultime.Service.ServiceImpl;
import com.example.luv2code.ultime.apiResponse.ApiResponse;
import com.example.luv2code.ultime.Exception.NotFoundException;
import com.example.luv2code.ultime.departement.Departement;
import com.example.luv2code.ultime.dto.InstructorDto;
import com.example.luv2code.ultime.Service.Service;
import com.example.luv2code.ultime.course.Course;
import com.example.luv2code.ultime.dto.StudentDto;
import com.example.luv2code.ultime.istructor.Instructor;
import com.example.luv2code.ultime.istructor.InstructorRepository;
import com.example.luv2code.ultime.niveau.Niveau;
import com.example.luv2code.ultime.student.Student;
import com.example.luv2code.ultime.student.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private Service service;
   private InstructorRepository instructorRepository;

   private StudentRepository studentRepository;

   @Value("${coach.name}")
   private String coachName;

   @Value("${team.name}")
   private String teamName;

    public Controller(Service service ,InstructorRepository instructorRepository,StudentRepository studentRepository) {
        this.instructorRepository=instructorRepository;
        this.service = service;
        this.studentRepository=studentRepository;
    }


    @RequestMapping(value = "api/info",method = RequestMethod.GET)
    public ApiResponse<String> getinfo(){
        return new ApiResponse<>( "the name of coah is "+coachName+" and the team name is "+teamName,200,"success");
    }
    @RequestMapping(value = "/api/addIns", method = RequestMethod.POST)
    public ApiResponse<Instructor> addInst(@RequestBody Instructor instructor)  {
        return new ApiResponse<>(service.addInstructor(instructor),200,"Added with succesfull");

    }

    @RequestMapping(value = "/api/addCours", method = RequestMethod.POST)
    public ApiResponse<Course>addCours(@RequestBody Course course) {
        return new ApiResponse<>(service.addCourse(course),200,"Added with succesfull");
    }

    @RequestMapping(value = "/api/getAllInstructor", method = RequestMethod.GET)
    public ApiResponse<List<Instructor>> getAllInstructor() {
        List<Instructor> instructors = service.getAllIns();
        if (instructors.isEmpty()) {
            throw new IllegalStateException("the list is empty");
        }
        return new ApiResponse<>(service.getAllIns(),200,"successful");
    }

    @RequestMapping(value = "api/getAllcours", method = RequestMethod.GET)
    public ApiResponse<List<Course>> getallCours() {
        return new ApiResponse<>(service.geAllCours(), 200, "successful");
    }

    @RequestMapping(value= "api/addStudnt", method = RequestMethod.POST)
    public ApiResponse<Student> addStudent(@RequestBody Student student){
        return new ApiResponse<>(service.addStudent(student),200,"Added with succesful");
    }

    @RequestMapping(value = "api/getAllStudent", method = RequestMethod.GET)
    public ApiResponse<List<Student>> getAllstd() {
        return new ApiResponse<>(service.getAllStudent(),200,"successful");
    }

    @RequestMapping(value = "api/updateIns/{id}",method = RequestMethod.PUT)
    public  void updateinstructor(@PathVariable("id") Integer id, @RequestBody InstructorDto instructorDto)
    {
        service.updateInstructor(id, instructorDto);

    }

    @RequestMapping(value = "api/updateStd/{id}", method = RequestMethod.PUT)
    public  void  updateStudent(@PathVariable("id") Integer id, @RequestBody StudentDto studentDto){
         service.updateStudent(id,studentDto);
    }

    @RequestMapping(value = "getInstructor/{id}",method = RequestMethod.GET)
    public ApiResponse<Optional<Instructor>> getInstructorById(@PathVariable("id") Integer id) throws NotFoundException {
        boolean exist=instructorRepository.existsById(id);

        if (!exist){
            throw new NotFoundException("the student does not exist");
        }
           return new ApiResponse<>(service.getInstById(id),200,"success");
    }
    @RequestMapping(value = "api/getAllNiv", method = RequestMethod.GET)
    public ApiResponse<List<Niveau>> getallniveau(){

        return new ApiResponse<>(service.getAllNiveau(),200,"successfulll");
    }

    @RequestMapping(value = "addstudent in level",method = RequestMethod.PUT)
    public void addStdToNIv(String StudentEmail,String niveauName){
        service.addStudentToNiveau( StudentEmail,niveauName);
    }

    @RequestMapping(value = "add student in course",method = RequestMethod.PUT)
    public void addStdToCours(String StudentEmail,String coursName){
        service.addStudentToCourse(StudentEmail,coursName);
    }

    @RequestMapping(value = "totalStudent",method = RequestMethod.GET)
    public ApiResponse<Long> NbreCandidats(){
        Long l= studentRepository.count();
      return new ApiResponse<>(l,200,"success");
    }
    @RequestMapping(value = "addDpt",method = RequestMethod.POST)
    public ApiResponse<Departement> addDepartement(@RequestBody Departement departement){
        return new ApiResponse<>(service.addDepartement(departement),200,"success");
    }


    @RequestMapping(value = "getallDpt",method = RequestMethod.GET)
    public ApiResponse<List<Departement>> getAlldepartement(){
        return new ApiResponse<>(service.getAllDpt(),200,"success");
    }
    @RequestMapping(value = "addlevelindpt",method =RequestMethod.POST)
    public void addLevelInDpt(String departementName,String niveauName){
          service.addDptinlevel(departementName,niveauName);
    }



}
