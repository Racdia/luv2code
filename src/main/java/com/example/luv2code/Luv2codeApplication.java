package com.example.luv2code;

import com.example.luv2code.ultime.course.Course;

import com.example.luv2code.ultime.departement.Departement;
import com.example.luv2code.ultime.istructor.Instructor;
import com.example.luv2code.ultime.Service.Service;
import com.example.luv2code.ultime.niveau.Niveau;
import com.example.luv2code.ultime.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Luv2codeApplication implements CommandLineRunner {



	private Service service;

	public Luv2codeApplication(Service service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(Luv2codeApplication.class, args);

		System.out.println("hello racine");
	}

	@Override
	public void run(String... args) {

		service.addInstructor(new Instructor("racine","racine@gmail.com","dixinn"));
		service.addInstructor(new Instructor("binta","binta@gmail.com","dixinn"));
		//service.addInstructor(new Instructor("binta","raci@gmail.com","dixinn"));

		service.addCourse(new Course("spring-boot"));
		service.addCourse(new Course("react-js"));

		//service.addInsToCours("racine","spring-boot");
		service.addInsToCours("binta","spring-boot");
		service.addInsToCours("racine","react-js");

		service.addStudent(new Student("Mamadou Racine","Diallo","racine60@gmail.com","dixin"));
		service.addStudent(new Student("Boussouriou","Diallo","yg@gmail.com","montreal"));

		service.addStudentToCourse("racine60@gmail.com","spring-boot");
		service.addStudentToCourse("yg@gmail.com","react-js");

		service.addNiveau(new Niveau("Licence 1"));
		service.addNiveau(new Niveau("Licence 2"));

		service.addStudentToNiveau("racine60@gmail.com","Licence 1");
		service.addStudentToNiveau("yg@gmail.com","Licence 2");

        service.addDepartement(new Departement("Genie-civil"));
		service.addDepartement(new Departement("Genie-informatique"));

		service.addDptinlevel("Genie-informatique","Licence 1");

		service.addDptinlevel("Genie-civil","Licence 2");



	}
}
