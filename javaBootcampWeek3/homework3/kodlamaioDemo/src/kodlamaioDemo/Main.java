package kodlamaioDemo;

import kodlamaioDemo.business.categoryManager;
import kodlamaioDemo.business.courseManager;
import kodlamaioDemo.business.instructorManager;
import kodlamaioDemo.core.logging.databaseLogger;
import kodlamaioDemo.core.logging.fileLogger;
import kodlamaioDemo.core.logging.iLogger;
import kodlamaioDemo.core.logging.mailLogger;
import kodlamaioDemo.dataAccess.hibernate.hibernateCategoryDao;
import kodlamaioDemo.dataAccess.jdbc.jdbcCourseDao;
import kodlamaioDemo.dataAccess.jdbc.jdbcInstructorDao;
import kodlamaioDemo.entities.Category;
import kodlamaioDemo.entities.Course;
import kodlamaioDemo.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {

		Course course = new Course(1, "Java", "Engin Demiroğ", 500);
		// Course course2 = new Course(2,"JavaScript","Engin Demiroğ",-10);
		// Course course3 = new Course(3,"Java","Engin Demiroğ",150);
		courseManager CourseManager = new courseManager(new jdbcCourseDao(),
				new iLogger[] { new databaseLogger(), new fileLogger(), new mailLogger() });
		CourseManager.add(course);
		// CourseManager.add(course2);
		// CourseManager.add(course3);

		Category category = new Category(1, "Programlama");
		// Category category2 = new Category(2,"Programlama");
		categoryManager CategoryManager = new categoryManager(new hibernateCategoryDao(),
				new iLogger[] { new databaseLogger(), new fileLogger(), new mailLogger() });
		CategoryManager.add(category);
		// CategoryManager.add(category2);

		Instructor instructor = new Instructor(1, "Engin Demiroğ");
		instructorManager InstructorManager = new instructorManager(new jdbcInstructorDao(),
				new iLogger[] { new databaseLogger(), new fileLogger(), new mailLogger() });
		InstructorManager.add(instructor);

	}

}
