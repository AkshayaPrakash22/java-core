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
        
        Battery battery = context.getBean("battery", Battery.class);
        System.out.println("\nProducts are:");
        System.out.println("Product ID: " + battery.getProduct_id());
        System.out.println("Product Name: " + battery.getProduct_name());
        System.out.println("Price: " + battery.getPrice());
        System.out.println("Rechargeable: " + battery.isRechargeable());

        System.out.println();

        
        Disc disc = context.getBean("disc", Disc.class);
        
        System.out.println("Product ID: " + disc.getProduct_id());
        System.out.println("Product Name: " + disc.getProduct_name());
        System.out.println("Price: " + disc.getPrice());
        System.out.println("Capacity: " + disc.getCapacity());

        
        

	}

}
