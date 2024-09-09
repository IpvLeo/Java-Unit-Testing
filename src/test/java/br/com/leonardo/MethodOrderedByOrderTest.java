package br.com.leonardo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;


//@Order(2)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedByOrderTest {
	
	StringBuilder actualValue = new StringBuilder("");

	@AfterEach
	void afterEach() {
		System.out.println("The actual value is: " + actualValue);
	}
	
	@Test
	@Order(1)
	void testC(){
		System.out.println("Running Test C");
		actualValue.append("1");
	}
	
	
	@Test
	@Order(2)
	void testD() {
		System.out.println("Running Test D");
		actualValue.append("2");
	}
	
	
	@Test
	@Order(3)
	void testA() {
		System.out.println("Running Test A");
		actualValue.append("3");
	}

	@Test
	@Order(4)
	void testB() {
		System.out.println("Running Test B");
		actualValue.append("4");
	}

}
