package br.com.leonardo;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(4)
class FooBarTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		System.err.println("Hello Junit 5!");
	}

}
