package com.junit5;

import java.util.Arrays;

public class JUnit_basics {
	public int add(int a, int b) {
		return a+b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
	
	public boolean isEven(int a) {
		if(a%2 == 0)
			return true;
		else
			return false;
	}
	
	public int[] sortArray(int a[]) {
		Arrays.sort(a);
		return a;		
	}
}
