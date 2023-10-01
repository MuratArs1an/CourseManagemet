package com.muratArslan.crudDemo;

import com.muratArslan.crudDemo.dao.AppDao;
import com.muratArslan.crudDemo.entity.Course;
import com.muratArslan.crudDemo.entity.Instructor;
import com.muratArslan.crudDemo.entity.InstructorDetail;
import com.muratArslan.crudDemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
			//createInstructor(appDao);
			//findInstructorById(appDao);
			//removeInstructorById(appDao);
			//findInstructorDetailById(appDao);
			//removeInstructorDetailById(appDao);
			//createInstructorWithCourses(appDao);
			//findInstructorWithCoursesById(appDao);
			//findCoursesForInstructor(appDao);
			//findInstructorWithCoursesJoinFetch(appDao);
			//updateInstructor(appDao);
			//updateCourse(appDao);
			//removeCourseById(appDao);
			//createCourseAndReviews(appDao);
			//retrieveCourseAndReviews(appDao);
			deleteCourseAndReviews(appDao);

		};
	}

	private void deleteCourseAndReviews(AppDao appDao) {
		int id=10;
		System.out.println("Deleted Course id: "+id);
		appDao.deleteCourseById(id);
	}

	private void retrieveCourseAndReviews(AppDao appDao) {
		int id=10;
		Course tempCourse=appDao.findCourseAndReviewByCourseId(id);
		System.out.println(tempCourse.toString());
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDao appDao) {
		//create a course
		Course tempCourse=new Course("Pacman- How to Score One Million Points");

		// add some reviews
		tempCourse.addReview(new Review("Very good course"));
		tempCourse.addReview(new Review("I did One million points with that course"));
		tempCourse.addReview(new Review("So bad course I had only 20 points"));
		//save the course
		System.out.println("Saving Course and Reviews");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDao.saveCourse(tempCourse);
	}

	private void removeCourseById(AppDao appDao) {
		int id=10;
		System.out.println("Deleted Course id: "+appDao.findCourseById(id).getTitle());
		appDao.deleteCourseById(id);

	}

	private void updateCourse(AppDao appDao) {
		int id=10;
		Course tempCourse=appDao.findCourseById(id);
		tempCourse.setTitle("Play piano");
		appDao.updateCourse(tempCourse);
		System.out.println("Updated : "+tempCourse.getTitle());
	}

	private void updateInstructor(AppDao appDao) {
		int id=1;
		Instructor tempInstructor=appDao.findById(id);
		tempInstructor.setLastName("TEST");
		appDao.update(tempInstructor);
		System.out.println("Insturctor Updated : " + tempInstructor);
		System.out.println("DONE");

	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		int id=1;
		System.out.println("Finding Instructor id" + id);
		Instructor tempInstructor=appDao.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor =" +tempInstructor);
		System.out.println("Instrctor courses = "+tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDao appDao) {
		int id=1;
		Instructor tempInstructor=appDao.findById(id);
		System.out.println("Instructor: "+ tempInstructor);

		//find courses for instructor
		List<Course> courses=appDao.findCoursesByInstructorId(id);

		//associate courses
		tempInstructor.setCourses(courses);
		System.out.println("associated courses :"+ tempInstructor.getCourses());
		System.out.println("Done !");

	}

	private void findInstructorWithCoursesById(AppDao appDao) {
		int id=1;
		Instructor tempInstructor=appDao.findById(id);
		System.out.println("Instructor: "+ tempInstructor);
		System.out.println("Courses :"+tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor tempInstructor=new Instructor("kilic", "Arslan", "kilcuk@gmail.com" );

		InstructorDetail tempInstructorDetail=new InstructorDetail("youtube","video games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//create some courses

		Course tempCourse1=new Course("Guitar Course");
		Course tempCourse2=new Course("Java Programing");
		Course tempCourse3=new Course("Swimming Course");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		//saving instructor
		System.out.println("Saving" +tempInstructor);
		System.out.println("Courses" +tempInstructor.getCourses());
		appDao.save(tempInstructor);
	}

	private void removeInstructorDetailById(AppDao appDao) {
		int id=3;
		appDao.deleteInstructorDetailById(id);
	}

	private void findInstructorDetailById(AppDao appDao) {
		int id=1;
		InstructorDetail tempInstructorDetail=appDao.findInstructorDetailById(id);
		System.out.println(tempInstructorDetail.getInstructor().getFirstName());
	}

	private void removeInstructorById(AppDao appDao) {
		int id=1;
		appDao.deleteById(id);
		System.out.println(id+" id instructor deleted");
	}

	private void findInstructorById(AppDao appDao) {
		int id=1;
		Instructor tempInstructor=appDao.findById(id);
		System.out.println(tempInstructor.getFirstName() +" "+ tempInstructor.getLastName());
		System.out.println(tempInstructor.getInstructorDetail().getHobby());
	}

	private void createInstructor(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Murat", "Arslan", "muratArslan@gmail.com" );

		InstructorDetail tempInstructorDetail=new InstructorDetail("youtube/murat","reading book");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving....");
		appDao.save(tempInstructor);
		System.out.println("DONE");
	}

}
