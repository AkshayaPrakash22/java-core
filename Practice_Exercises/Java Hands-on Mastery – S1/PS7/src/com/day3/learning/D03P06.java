package com.day3.learning;

import java.util.TreeSet;

public class D03P06 {

	public static void main(String[] args) {
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

		// Print the id, name, and salary of each person
		System.out.println("ID\tName\tSalary");
		for (Person person : personSet) {
			System.out.println(person.getId() + "\t" + person.getName() + "\t" + person.getSalary());
		}
	}

}
