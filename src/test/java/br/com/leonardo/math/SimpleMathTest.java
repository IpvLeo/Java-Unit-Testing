package br.com.leonardo.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleMathTest {

    @Test
    void testSum() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.sum(firstNumber, secondNumber);
        double expected = 8.2D;
       
        assertEquals(expected, actual, () -> firstNumber + "+" + secondNumber + " did not produce " + expected);
        assertNotEquals(9.2, actual);
        assertNotNull(actual);
    }
    
    @Test
    void testSubtraction() {
    	SimpleMath math = new SimpleMath();
    	Double actual = math.subtraction(5.5D, 0.5d);
    	double expected = 5.0D;
    	
    	assertEquals(expected, actual);
    }
    
    @Test
    void testMultiplication() {
    	SimpleMath math = new SimpleMath();
    	double firstNumber = 6.5D;
		double secondNumber = 2D;
		
		Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 13D;
        
        assertEquals(expected, actual, () -> firstNumber + "*" + secondNumber + " did not produce " + expected);
       
    }
    
    @Test
    void testDivision() {
    	SimpleMath math = new SimpleMath();
    	double firstNumber = 0.0D;
		double secondNumber = 2D;
		
		Double actual = math.division(firstNumber, secondNumber);
        double expected = 0D;
        
        assertEquals(expected, actual, () -> firstNumber + "/" + secondNumber + " did not produce " + expected);
        assertNotEquals(0, firstNumber, "O denominador não pode ser zero");
        
    }
    
    @Test
    void testMean() {
    	SimpleMath math = new SimpleMath();
    	double firstNumber = 2.0D;
		double secondNumber = 2.0D;
		
		Double actual = math.mean(firstNumber, secondNumber);
        double expected = 2D;
        
        assertEquals(expected, actual, () -> firstNumber + "" + secondNumber + " did not produce " + expected);
        
    }
    
    
    
    @Test
    void testSquareRoot() {
    	SimpleMath math = new SimpleMath();
    	double Number = 25D;
		
		Double actual = math.squareRoot(Number);
        double expected =4D;
        
        assertEquals(actual, expected, () ->  "Square Root  did not produce " + expected  );
        
    }
    
    
    
    
    

 
    
    

}
