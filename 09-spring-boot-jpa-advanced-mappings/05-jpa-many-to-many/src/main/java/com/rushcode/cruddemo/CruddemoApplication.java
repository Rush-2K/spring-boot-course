package com.rushcode.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rushcode.cruddemo.dao.AppDAO;
import com.rushcode.cruddemo.entity.Course;
import com.rushcode.cruddemo.entity.Review;
import com.rushcode.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {

			// createCourseAndStudents(appDAO);

			// findCourseAndStudents(appDAO);

			// findStudentsAndCourse(appDAO);

			// addMoreCoursesForStudent(appDAO);

			// only delete course, not student
			// deleteCourse(appDAO);

			deleteStudent(appDAO);

		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Deleting student id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("Rubick's Cube - How to Speed Cube");
		Course tempCourse2 = new Course("How to Launder Money");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Update student: " + tempStudent);
		System.out.println("Associated course: " + tempStudent.getCourse());

		appDAO.update(tempStudent);

		System.out.println("Done update");
	}

	private void findStudentsAndCourse(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourse());

		System.out.println("Done");

	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());

		System.out.println("Done");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How to Score One Million Points");

		// create the students
		Student tempStudent1 = new Student("John", "Doe", "john@rush.com");
		Student tempStudent2 = new Student("Lewis", "Hamilton", "lewis@rush.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("Saving the student: " + tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Done save");

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How to Score One Million Points");

		// add some reviews
		tempCourse.addReview(new Review("Great course... loved it!"));
		tempCourse.addReview(new Review("Cool course, well done"));
		tempCourse.addReview(new Review("Not a really good course"));

		// save the course
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

}
