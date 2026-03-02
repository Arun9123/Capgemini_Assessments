package com.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class Exception_1_test {

	
	@BeforeAll
	public void beforeAll() {
		System.out.println("Before All");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Before Each");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("After Each");
	}
	
	@AfterAll
	public void afterAll() {
		System.out.println("After All");
	}
	
	@Test
	void testPrintArray() {
		try {
			int arr[] = null;
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException encountered");
		}
		catch (NullPointerException e) {
			System.out.println("NullPointerException encountered");
		}
		
	}
	
	@Test
	void testBeyondArray() {
		try {
			int arr[] = {1, 2, 3, 4, 5};
			for (int i = 0; i <= arr.length; i++) {
				System.out.println(arr[i]);
			}
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException encountered");
		}
		catch (NullPointerException e) {
			System.out.println("NullPointerException encountered");
		}
		
	}

}
