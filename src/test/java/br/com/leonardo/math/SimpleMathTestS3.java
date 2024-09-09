package br.com.leonardo.math;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleMathTestS3 {

	SimpleMath math;
	
	@BeforeAll
	static void setup() {
		System.out.println("Running @BeforeAll method!");
	}
	
	@AfterAll
	static void cleanup() {
		System.out.println("Running @AfterAll method!");
	}
	
	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
		System.out.println("Running @BeforeEach method!");
	}
	
	@AfterEach
	void afterEachMethod() {
		System.out.println("Running @AfterEach method!");
	}
	
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_SholdReturnEightDotTwo() {
    	
    	System.out.println("Test 6.2 + 2 = 8.2");
    	
    	//AAA Arrange, Act, Assert
    	//Given / Arrage
        
        double firstNumber = 6.2D;
		double secondNumber = 2D;
		double expected = 8.2D;
		
		//Then / Act
		Double actual = math.sum(firstNumber, secondNumber);
       
		//When /Assert
        assertEquals(expected, actual, () -> firstNumber + "+" + secondNumber + " did not produce " + expected);
        assertNotEquals(9.2, actual);
        assertNotNull(actual);
    }
    
    @Test
    @DisplayName("Test 5.5 - 0.5 = 5.0")
    void testSubtraction() {
    	Double actual = math.subtraction(5.5D, 0.5d);
    	double expected = 5.0D;
    	
    	assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test 6.5 * 2 = 13")
    void testMultiplication() {
    	double firstNumber = 6.5D;
		double secondNumber = 2D;
		
		Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 13D;
        
        assertEquals(expected, actual, () -> firstNumber + "*" + secondNumber + " did not produce " + expected);
       
    }
    
    @Test
    @DisplayName("Test 6.0 / 2 = 3")
    void testDivision() {
    	double firstNumber = 6.0D;
		double secondNumber = 2D;
		
		Double actual = math.division(firstNumber, secondNumber);
        double expected = 3D;
        
        assertEquals(expected, actual, () -> firstNumber + "/" + secondNumber + " did not produce " + expected);
        
        
    }
    
    //@Disabled("Todo: We need still work on it")
    @Test
    @DisplayName("Test Division by zero")
    void  testDivision_When_FirstNumberIsDividedByZero_SholdThorowAritmeticException() {
    	//given
    	double firstNumber = 6.2D;
    	double secondNumber = 2D;

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


    @Test
    @DisplayName("Test (2.0 + 2.0) / 2 = 2")
    void testMean() {
    	double firstNumber = 2.0D;
		double secondNumber = 2.0D;
		
		Double actual = math.mean(firstNumber, secondNumber);
        double expected = 2D;
        
        assertEquals(expected, actual, () -> firstNumber + "" + secondNumber + " did not produce " + expected);
        
    }
    
    
    
    @Test
    @DisplayName("Test Square Root of 25 = 5")
    void testSquareRoot() {
    	
    	double Number = 25D;
		
		Double actual = math.squareRoot(Number);
        double expected =5D;
        
        assertEquals(actual, expected, () ->  "Square Root  did not produce " + expected  );
        
    }
    
    
    
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
	@Test
	@DisplayName("Display Name")
	void testeABC_When_XYZ_Shold() {
		//Given
		//When
		//Then

	}

 
    
    

}
