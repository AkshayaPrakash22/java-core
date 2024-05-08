package com.learning.day5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

	        // Get all bean names
	        String[] beanNames = context.getBeanDefinitionNames();

	        // Print all bean names
	        System.out.println("Beans created by the container:");
	        for (String beanName : beanNames) {
	            System.out.println(beanName);
	        }
	        
	        

	}

}
