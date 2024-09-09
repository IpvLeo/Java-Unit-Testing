package br.com.leo.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.leo.CourseBusiness;
import br.com.leo.service.CourseService;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {
	
	
	@Mock
	CourseService mockService;
	
	@InjectMocks
	CourseBusiness business; 
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	List<String> courses;
	
	@BeforeEach
	void setup () {
		//business = new CourseBusiness(mockService);
		courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
            );
	}
	
	@Test
	void testeCoursesRelatedToSpring_When_UsingMock() {
		// Given

		given(mockService.retrieveCourses("Leonardo")).willReturn(courses);


		//When
		var filteredCourses = business.retriveCoursesRelatedToSpring("Leonardo");
		
		//Then
		assertThat(filteredCourses.size(), is(4));

	}
	
	// test[System Under Test]_[Condition or State Change]_[Expected Result]
	@Test
	@DisplayName("Delete Courses not Related to Spring Using Mockito sould call Method")
	void DeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Shold_CallMethod_deleteCourse() {
		
		//Given
		given(mockService.retrieveCourses("Leonardo"))
		.willReturn(courses);
		
		//When
		business.deleteCourseNotRelatedToSpring("Leonardo");
		
		//Then
		verify(mockService, times(1)).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
		verify(mockService).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
		verify(mockService, atLeast(1)).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
		verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");

	}
	

	// test[System Under Test]_[Condition or State Change]_[Expected Result]
	@Test
	@DisplayName("Delete Courses not Related to Spring Using Mockito sould call Method V2")
	void DeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Shold_CallMethod_deleteCourseV2() {

		//Given
		given(mockService.retrieveCourses("Leonardo"))
		.willReturn(courses);

		String kotlinCourse = "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android";
		String architetureCourse = "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#";
		String restSpringCourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker";

		//When
		business.deleteCourseNotRelatedToSpring("Leonardo");

		//Then
		then(mockService).should().deleteCourse(kotlinCourse);
		then(mockService).should().deleteCourse(architetureCourse);
		then(mockService).should(never()).deleteCourse(restSpringCourse);

	}
	
	@Test
	@DisplayName("Delete Courses not Related to Spring Capturing Arguments sould call Method")
	void DeleteCoursesNotRelatedToSpring_CapturingArguments_Shold_CallMethod_deleteCourse() {

		//Given
		given(mockService.retrieveCourses("Leonardo"))
			.willReturn(courses);
		
		//ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

		//When
		business.deleteCourseNotRelatedToSpring("Leonardo");

		//Then
		then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(), is(7));


	}
}




