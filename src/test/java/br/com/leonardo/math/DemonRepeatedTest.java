package br.com.leonardo.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class DemonRepeatedTest {


	SimpleMath math;
	
	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
		System.out.println("Running @BeforeEach method!");
	}

	@RepeatedTest(value = 3, name = "{displayName}. Repetition" + 
	"{currentRepepetition} of {totalRepetitions}!")
	@DisplayName("Test Division by zero")
	void  testDivision_When_FirstNumberIsDividedByZero_SholdThorowAritmeticException(
			RepetitionInfo repetitionInfo,
			TestInfo testInfo
			) {
		System.out.println("Repetition N° " + repetitionInfo.getCurrentRepetition() +
		" of " + repetitionInfo.getTotalRepetitions());
		System.out.println("Running" + testInfo.getTestMethod().get().getName());
		//given
		double firstNumber = 6.2D;
		double secondNumber = 0D;

		var  expectedMessage = "Impossible to divide by zero!";

		//when & then
		ArithmeticException actual = assertThrows(
				ArithmeticException.class, () -> {
					//when & then
					math.division(firstNumber, secondNumber);
				}, () -> "Division by zero shold throw an ArithmeticException");

		assertEquals(expectedMessage, actual.getMessage(), 
				() -> "Unexpected exception message!");
	}

}
