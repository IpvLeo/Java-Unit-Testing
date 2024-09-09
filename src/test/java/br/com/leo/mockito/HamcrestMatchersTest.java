package br.com.leo.mockito;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {

	@Test
	void testHamcrestMatchers() {
		//Given
		List<Integer> scores = Arrays.asList(99, 100, 101,105);
		
		//When & Then
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(100, 101));
		assertThat(scores, everyItem(greaterThan(98)));
		assertThat(scores, everyItem(lessThan(106)));
		
		//Check Strings
		assertThat("", is(emptyString()));
		assertThat(" ", is(blankString()));
		assertThat(null, is(emptyOrNullString()));
		
		//Arrays
		Integer[] myArray = {1, 2, 3};
		assertThat(myArray, arrayWithSize(3));
		assertThat(myArray, arrayContaining(1, 2, 3));
		assertThat(myArray, arrayContainingInAnyOrder(2, 1, 3));
	}
	
}
