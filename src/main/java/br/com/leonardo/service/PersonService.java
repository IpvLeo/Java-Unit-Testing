package br.com.leonardo.service;

import java.util.concurrent.atomic.AtomicLong;

import br.com.leonardo.model.Person;

public class PersonService implements IPersonService{


	@Override
	public Person createPerson(Person person) {
		if(person.getEmail() == null || person.getEmail().isBlank())
			throw new IllegalArgumentException("The Parson e- Mail is null or empty!");
			
		
		var id =  new AtomicLong().incrementAndGet();
		person.setId(id);
		return person;
	}

}
