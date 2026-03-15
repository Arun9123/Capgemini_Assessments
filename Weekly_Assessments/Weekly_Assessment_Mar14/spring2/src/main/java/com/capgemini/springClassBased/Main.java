package com.capgemini.springClassBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		People people = context.getBean(People.class);
		Bike bike = (Bike)context.getBean("hero");
		
		PojoClass pojoClass = context.getBean(PojoClass.class);
		
		System.out.println(people);
		System.out.println(bike);
		System.out.println(pojoClass);
	}
}
