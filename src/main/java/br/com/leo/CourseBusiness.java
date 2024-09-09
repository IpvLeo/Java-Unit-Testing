package br.com.leo;

import java.util.ArrayList;
import java.util.List;

import br.com.leo.service.CourseService;

//CourseBusiness = SUT - System (Method) Under Test
public class CourseBusiness {
	
	// CourseService is a Depedency
	private CourseService service;

	public CourseBusiness(CourseService service) {
		this.service = service;
	}
	
	public List<String> retriveCoursesRelatedToSpring(String stundent) {
		
		var filteredCourses = new ArrayList<String>();
		if("Foo Bar".equals(stundent)) return filteredCourses;
		var allCourses = service.retrieveCourses(stundent);
		
		for(String course : allCourses) {
            if (course.contains("Spring")) {
                filteredCourses.add(course);
            }
		}
		return filteredCourses;
	}
	
public void deleteCourseNotRelatedToSpring(String stundent) {
		
		
		var allCourses = service.retrieveCourses(stundent);
		
		for(String course : allCourses) {
            if (!course.contains("Spring")) {
                service.deleteCourse(course);
            }
		}
	}
	
}
