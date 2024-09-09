package br.com.leonardo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.leonardo.model.Person;
import br.com.leonardo.service.IPersonService;
import br.com.leonardo.service.PersonService;

public class PersonServiceTest {


	Person person;
	IPersonService service;

	@BeforeEach
	void setup () {
		service = new PersonService();
		person = new Person(
				"Keith",
				"Moon",
				"kmoon@eudio.com.br",
				"Wembley - UK",
				"Male"
				);
	}

	@Test
	@DisplayName("When Create a Person With Success Shold Return a Person Object")
	void testCreatePerson_WhenSucess_ShouldReturnPersonObject() {
		//Given / Arrange

		//When / Act
		Person actual = service.createPerson(person);

		//Then/ Assert 
		assertNotNull(actual,
				() -> "The createPerson() should not have returned null!");
	}

	@Test
	@DisplayName("When Create a Person With Success Shold Contains Valid  Fields in Return a Person Object")
	void testCreatePerson_WhenSucess_ShouldContainsValidFieldsInIPersonObject() {

		//Given / Arrange

		//When / Act
		Person actual = service.createPerson(person);

		//Then / Assert 
		assertNotNull(person.getId(), () -> "Person ID is Missing");
		assertEquals(person.getFirstName(), actual.getFirstName(),
				() -> "The createPerson() should not have returned null");
		assertEquals(person.getLastName(), actual.getLastName(),
				() -> "The createPerson() should not have returned null");
		assertEquals(person.getId(), actual.getId(),
				() -> "The createPerson() should not have returned null");
		assertEquals(person.getAddress(), actual.getAddress(),
				() -> "The createPerson() should not have returned null");
		assertEquals(person.getGender(), actual.getGender(),
				() -> "The createPerson() should not have returned null");
	}

	// Cenario para criar o teste se as mesangem do excepetion são iguais 
	@Test
	@DisplayName("When Create a Person With null e-Mail Shold throw Exception")
	void testCreatePerson_WhithNullEMail_SholdThrowIllegalArgumentException() {
		//Given / Arrange
		person.setEmail(null);

		var expectedMessage = "The Parson e- Mail is null or empty!";
		//When / Act

		//Then / Assert 
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> service.createPerson(person),
				() -> "Empty e-Mail should hava cause an illegalArgumentoExcetion!"
				);

		//Then / Assert
		assertEquals(expectedMessage,
				exception.getMessage(),
				() -> "Exception error message is incorrect!");
	}
}
