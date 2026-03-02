package com.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TDD_test1 {
	TDD_basics1 t = new TDD_basics1();
	
	@Test
	void revTest() {
		assertEquals("olleh", t.rev("hello"));
	}
	
	@Test
	void revTest2() {
		assertEquals("olleh", t.rev("hello"));
	}
}
