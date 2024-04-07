package com.day3.learning;

import java.util.TreeSet;

public class D03P08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Person> personSet = new TreeSet<>();

		// Predefined person information
		Person person1 = new Person(1, "Jerry", 20, 999.0);
		Person person2 = new Person(2, "Smith", 25, 2999.0);
		Person person3 = new Person(3, "Popeye", 23, 5999.0);
		Person person4 = new Person(4, "Jones", 18, 6999.0);
		Person person5 = new Person(5, "John", 32, 1999.0);
		Person person6 = new Person(6, "Tom", 42, 3999.0);

		// Storing persons in TreeSet
		personSet.add(person1);
		personSet.add(person2);
		personSet.add(person3);
		personSet.add(person4);
		personSet.add(person5);
		personSet.add(person6);

		double sum = 0;
		for (Person person : personSet) {
			sum += person.getSalary();
		}

		// Print the sum of all salaries
		System.out.println("Sum of all salaries: " + sum);
	}

}
