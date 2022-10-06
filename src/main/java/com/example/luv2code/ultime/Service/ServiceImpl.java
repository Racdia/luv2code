package com.example.luv2code.ultime.Service;



import com.example.luv2code.ultime.Email.Emailvalidator;
import com.example.luv2code.ultime.Exception.NotFoundException;
import com.example.luv2code.ultime.departement.Departement;
import com.example.luv2code.ultime.departement.DepartementRepository;
import com.example.luv2code.ultime.dto.InstructorDto;
import com.example.luv2code.ultime.course.CoursRepository;
import com.example.luv2code.ultime.course.Course;
import com.example.luv2code.ultime.dto.StudentDto;
import com.example.luv2code.ultime.istructor.Instructor;
import com.example.luv2code.ultime.istructor.InstructorRepository;
import com.example.luv2code.ultime.niveau.Niveau;
import com.example.luv2code.ultime.niveau.NiveauRepository;
import com.example.luv2code.ultime.student.Student;
import com.example.luv2code.ultime.student.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.example.luv2code.ultime.utils.Utils.isNotBlank;

@org.springframework.stereotype.Service
@Transactional

public class ServiceImpl implements Service {

    private InstructorRepository instructorRepository;
    private CoursRepository coursRepository;

    private Emailvalidator emailvalidator;

    private StudentRepository studentRepository;

    private NiveauRepository niveauRepository;

    private DepartementRepository departementRepository;


    public ServiceImpl(DepartementRepository departementRepository,InstructorRepository instructorRepository,Emailvalidator emailvalidator, CoursRepository coursRepository,StudentRepository studentRepository,NiveauRepository niveauRepository) {
        this.instructorRepository = instructorRepository;
        this.coursRepository = coursRepository;
        this.studentRepository=studentRepository;
        this.emailvalidator=emailvalidator;
        this.niveauRepository=niveauRepository;
        this.departementRepository=departementRepository;
    }

    @Override
    public Instructor addInstructor(Instructor instructor)  {

          Optional<Instructor> optionalInstructor=instructorRepository.findInsByEmail(instructor.getEmail());
           if (!emailvalidator.test(instructor.getEmail())){
               throw new IllegalStateException("email is not valide");
           }
          if (optionalInstructor.isPresent()){
              throw new IllegalStateException("email is taken");
          }
        return instructorRepository.save(instructor);
    }

    @Override

    public Course addCourse(Course course) {
      return   coursRepository.save(course);
    }

    @Override
    public List<Instructor> getAllIns() {
        return instructorRepository.findAll();
    }

    @Override
    public List<Course> geAllCours() {
        return coursRepository.findAll();
    }

    @Override
    //@Order(1)
    public void addInsToCours(String username, String coursName)  {
      Instructor instructor=instructorRepository.findInsByName(username).orElseThrow(()->new IllegalStateException());
      Course course=coursRepository.findBycoursName(coursName);
      course.setInstructor(instructor);
      coursRepository.save(course);
     // course.getInstructor().getUsername();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent()  {
        List<Student> exist=studentRepository.findAll();

        if(exist.isEmpty()){
            throw new IllegalStateException("not found");
        }

        return studentRepository.findAll();
    }

    @Override
    public void addStudentToCourse(String studentEmail, String coursName) {
          Student student=studentRepository.findBystudentEmail(studentEmail).orElseThrow(()->new IllegalStateException("not found"));

          Course course=coursRepository.findBycoursName(coursName);


          student.getCourseList().add(course);
          course.getStudentList().add(student);

           studentRepository.save(student);
           coursRepository.save(course);


    }


    @Override
   // @Transactional
    public void updateInstructor(Integer id, InstructorDto instructorDto)  {
           Instructor instructor=instructorRepository.findById(id).orElseThrow(()->new IllegalStateException("impossible"));

           if(isNotBlank(instructorDto.getInstructorUsername()) && !instructorDto.getInstructorUsername().equals(instructor.getInstructorUsername())){
               instructor.setInstructorUsername(instructorDto.getInstructorUsername());
           }
           if (isNotBlank(instructorDto.getEmail()) && !instructorDto.getEmail().equals(instructor.getEmail())){

               instructor.setEmail(instructorDto.getEmail());
           }

           if (isNotBlank(instructorDto.getQuartier()) && !instructorDto.getQuartier().equals(instructor.getQuartier())){
               instructor.setQuartier(instructorDto.getQuartier());
           }

           instructorRepository.save(instructor);
        System.out.print(instructorDto);
    }

    @Override
    public void updateStudent(Integer id, StudentDto studentDto) {
       Student student=studentRepository.findById(id).orElseThrow(()->new IllegalStateException("not found"));

        if (isNotBlank(studentDto.getStudentFirstName()) && !studentDto.getStudentFirstName().equals(student.getStudentFirstName())){
            student.setStudentFirstName(studentDto.getStudentFirstName());
        }

        if (isNotBlank(studentDto.getStudentLastName()) && !studentDto.getStudentLastName().equals(student.getStudentLastName())){
            student.setStudentLastName(studentDto.getStudentLastName());
        }
        if (isNotBlank(studentDto.getStudentEmail()) && !studentDto.getStudentEmail().equals(student.getStudentEmail())){
            student.setStudentEmail(studentDto.getStudentEmail());
        }
        if (isNotBlank(studentDto.getAdresse()) && !studentDto.getAdresse().equals(student.getAdresse())){
            student.setAdresse(studentDto.getAdresse());
        }
            studentRepository.save(student);
    }

    @Override
    public void delleteCours(Integer id) throws NotFoundException {

        boolean exist=coursRepository.existsById(id);
        if (!exist){
            throw new NotFoundException("not found");
        }
         coursRepository.deleteById(id);
    }


    @Override
    public Optional<Instructor> getInstById(Integer id) {

        return instructorRepository.findById(id);
    }

    @Override
    public Niveau addNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public List<Niveau> getAllNiveau() {
        return niveauRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public void addStudentToNiveau(String StudentEmail, String niveauName) {
       Student student=studentRepository.findBystudentEmail(StudentEmail).orElseThrow(()  ->new IllegalStateException("not found"));

       Niveau niveau=niveauRepository.findByniveauName(niveauName).orElseThrow(()->new IllegalStateException("not found"));

       student.setNiveau(niveau);
       niveau.getStudentList().add(student);

       studentRepository.save(student);
       niveauRepository.save(niveau);
      // niveauRepository.save(niveau);
    }

    @Override
    public List<Departement> getAllDpt() {
        return departementRepository.findAll();
    }

    @Override
    public void addDptinlevel(String departementName, String niveauName) {
          Departement departement=departementRepository.findBydepartementName(departementName);

          Niveau niveau=niveauRepository.findByniveauName(niveauName).orElseThrow(()->new IllegalStateException("not found"));

          departement.getNiveauList().add(niveau);

          departementRepository.save(departement);
    }


   /* @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(Exception exception){
         ErrorResponse response=new ErrorResponse();

         response.setStatus(HttpStatus.NOT_FOUND.value());
         response.setMessage(exception.getMessage());
         response.setTimestamp(System.currentTimeMillis());
         return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }*/

}
