package com.capgemini.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
        
        Student student = (Student)context.getBean("student");
        System.out.println(student);
        
        Employee employee = (Employee)context.getBean("employee");
        System.out.println(employee);
        
    }
}
