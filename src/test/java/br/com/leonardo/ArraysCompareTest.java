package br.com.leonardo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


@Order(5)
class ArraysCompareTest {

	@Test
	//@Timeout(1)
	@Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
	void testSortPerfomance() {
		int[] numbers = {25,8,22,32,3};
		for(int i = 0; i < 100000; i++) {
			numbers[0] = 1;
			Arrays.sort(numbers);
		}
		
		
	}

}
