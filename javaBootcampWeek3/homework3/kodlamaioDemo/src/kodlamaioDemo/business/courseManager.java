package kodlamaioDemo.business;

import java.util.ArrayList;

import kodlamaioDemo.core.logging.iLogger;
import kodlamaioDemo.dataAccess.abstracts.courseDao;
import kodlamaioDemo.entities.Course;

public class courseManager {
	private ArrayList<String> availableCourses = new ArrayList<String>();
	private courseDao CourseDao;
	private iLogger[] loggers;

	public courseManager(courseDao CourseDao, iLogger[] loggers) {

		this.CourseDao = CourseDao;
		this.loggers = loggers;
	}

	public void add(Course course) throws Exception {
		if (course.getUnitPrice() < 0) {
			throw new Exception("Bir kursun fiyatı 0'dan küçük olamaz ");
		}
		if (availableCourses.contains(course.getCourseName())) {
			throw new Exception("Bu isimde bir kurs vardır ");
		}

		availableCourses.add(course.getCourseName());
		CourseDao.add(course);

		for (iLogger logger : loggers) {
			logger.log("Yeni bir kurs eklendi : " + course.getCourseName());
		}

	}

}
