package com.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test1 {

	JUnit_basics j = new JUnit_basics();
	
	@Test
	void testAdd() {
		
		int actual = j.add(2, 4);
		int expected = 6;
		assertEquals(expected, actual);
	}
	
	@Test
	void testMultiply() {
		assertEquals(8, j.multiply(2, 4));
	}
	
	@Test
	void testIsEven() {
		assertTrue(j.isEven(16));
	}
	
	@Test
	void testArraysEquals() {
		int a[] = {4,2,1,5,3};
		int res[] = {1,2,3,4,5};
		assertArrayEquals(res, j.sortArray(a));
	}

	
}
