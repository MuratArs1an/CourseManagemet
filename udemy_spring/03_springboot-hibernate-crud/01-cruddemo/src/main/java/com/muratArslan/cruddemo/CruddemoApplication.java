package com.muratArslan.cruddemo;

import com.muratArslan.cruddemo.dao.StudentDao;
import com.muratArslan.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class  CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			//createStudent(studentDao);
			//multipleStudent(studentDao);
			readStudent(studentDao);
		};
	}
	private void createStudent(StudentDao studentDao){
		//create student object
		System.out.println("Creating new student");
		Student tempStudent=new Student("Murat","Arslan","mrtrslm@gmail.com");
		//save the student object
		System.out.println("Saving student ....");
		studentDao.save(tempStudent);
		//display id of the saved student
		System.out.println("Student saved, generated id: "+tempStudent.getId());
	}

	private void multipleStudent(StudentDao studentDao){
		//create student object
		System.out.println("Creating 3 student");
		Student tempStudent1=new Student("Alp","Arslan","klcp@gmail.com");
		Student tempStudent2=new Student("Mustafa","Turk","mtk@gmail.com");
		Student tempStudent3=new Student("Mert","Can","mrtcn@gmail.com");

		System.out.println("Saving student ....");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);
	}

	private void readStudent(StudentDao studentDao){
		System.out.println("Creating Student");
		Student tempStudent=new Student("Duffy","Duck","duffduck@gamil.com");
		System.out.println("Saving Student");
		studentDao.save(tempStudent);
		int id= tempStudent.getId();
		System.out.println("Retrieving Student");
		Student theStudent= studentDao.findById(id);
		System.out.println(theStudent.toString());

	}


}
