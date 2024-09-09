package br.com.leo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.leo.CourseBusiness;
import br.com.leo.service.CourseService;
import br.com.leonardo.service.stubs.CourseServiceStub;

class CourseBusinessStubTest {

	@Test
	void testeCoursesRelatedToSpring_When_UsingStub() {
		//Given
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		//When
		var filteredCourses = business.retriveCoursesRelatedToSpring("Leonardo");
		
		//Then
		assertEquals(4, filteredCourses.size());

	}
	
	@Test
	void testeCoursesRelatedToSpring_When_UsingFooBarStudent() {
		//Given
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		//When
		var filteredCourses = business.retriveCoursesRelatedToSpring("Foo Bar");
		
		//Then
		assertEquals(0, filteredCourses.size());

	}
	
	
	
}
